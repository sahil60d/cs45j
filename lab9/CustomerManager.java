package labs.lab9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CustomerManager extends JFrame {
	
	private CustomerTracker customers;
	private JList<String> customerDisplay;
	private DefaultListModel<String> customerList;
	private JTextField name, email, amount;
	private JTextArea notes;
	private JCheckBox dog, cat, bird, fish, other;
	private JComboBox<String> location;
	private Customer displayed;
	
	public CustomerManager() {
		super("Sahil Desai - 82346084");
		customers = new CustomerTracker();
		customerList = new DefaultListModel<String>();
		displayed = null;
		
		//Create Components
		customerDisplay = new JList<>(customerList);
		name = new JTextField(20);
		email = new JTextField(20);
		amount = new JTextField("0.0", 10);
		notes = new JTextArea(3, 20);
		notes.setLineWrap(true);
		notes.setWrapStyleWord(true);
		dog = new JCheckBox("Dog(s)");
		cat = new JCheckBox("Cat(s)");
		bird = new JCheckBox("Bird(s)");
		fish = new JCheckBox("Fish");
		other = new JCheckBox("Other");
		location = new JComboBox<>(new String[]{"Irvine", "Los Angeles", "Paris", "Shanghai", "New York", "London"});
		location.setSelectedItem("Irvine");
		
		//Action Buttons
		JButton newCustomerButton = new JButton("New Customer");
		JButton saveCustomerButton = new JButton("Save Customer");
		JButton deleteCustomerButton = new JButton("Delete");
		
		//Action Button Listeners
		class NewCustomerAction implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		}
		
		class SaveCustomerAction implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveCustomer();
			}
		}
		
		class DeleteCustomerAction implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteCustomer();
			}
		}
		
		class SelectCustomerAction implements ListSelectionListener {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				displayCustomer();	
			}
		}
		
		//Add Listeners
		newCustomerButton.addActionListener(new NewCustomerAction());
		saveCustomerButton.addActionListener(new SaveCustomerAction());
		deleteCustomerButton.addActionListener(new DeleteCustomerAction());
		customerDisplay.addListSelectionListener(new SelectCustomerAction());
		
		//Layout
		setLayout(new GridLayout(1,2));
		
		//Left panel
		JPanel left = new JPanel(new BorderLayout());
		JPanel deleteButtonPanel = new JPanel();
		deleteButtonPanel.add(deleteCustomerButton);
		left.add(customerDisplay, BorderLayout.NORTH);
		left.add(deleteButtonPanel, BorderLayout.SOUTH);
		
		//Right panel
		JPanel right = new JPanel(new GridLayout(7,1));
		
		JPanel namePanel = new JPanel();
		namePanel.add(new JLabel("Name: "));
		namePanel.add(name);
		
		JPanel emailPanel = new JPanel();
		emailPanel.add(new JLabel("Email: "));
		emailPanel.add(email);
		
		JPanel petPanel = new JPanel(new GridLayout(1,6));
		petPanel.add(new JLabel("Pets: "));
		petPanel.add(dog);
		petPanel.add(cat);
		petPanel.add(bird);
		petPanel.add(fish);
		petPanel.add(other);
		
		JPanel amountPanel = new JPanel();
		amountPanel.add(new JLabel("Total Amount Spent: "));
		amountPanel.add(amount);
		
		JPanel locationPanel = new JPanel();
		locationPanel.add(new JLabel("Home Store Location: "));
		locationPanel.add(location);
		
		JPanel notesPanel = new JPanel();
		notesPanel.add(new JLabel("Notes: "));
		notesPanel.add(new JScrollPane(notes));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(saveCustomerButton);
		buttonPanel.add(newCustomerButton);
		
		right.add(namePanel);
		right.add(emailPanel);
		right.add(petPanel);
		right.add(amountPanel);
		right.add(locationPanel);
		right.add(notesPanel);
		right.add(buttonPanel);
		
		//Add to layout
		add(left);
		add(right);
		
		//Frame settings
		setSize(1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void clearFields() {
		customerDisplay.clearSelection();
		name.setText("");
		email.setText("");
		dog.setSelected(false);
		cat.setSelected(false);
		bird.setSelected(false);
		fish.setSelected(false);
		other.setSelected(false);
		amount.setText("0.0");
		location.setSelectedItem("Irvine");
		notes.setText("");
	}
	
	private void saveCustomer() {
		//validation check
		Double a = null;
		try {
			a = Double.parseDouble(amount.getText());
			if (name.getText().equals("") || email.getText().equals("") || a < 0.0) {
				invalid();
				return;
			}
		} catch (NumberFormatException e) {
			invalid();
			return;
		}
		
		//Add customer if none is selected, else add new customer
		if (customerDisplay.isSelectionEmpty()) {
			//If name already exists, invalid
			if (customerList.contains(name.getText())) {
				invalid();
				return;
			}
			
			//Add Customer
			Customer c = new Customer(name.getText(), email.getText(), a, (String) location.getSelectedItem(), notes.getText(), dog.isSelected(), cat.isSelected(), bird.isSelected(), fish.isSelected(), other.isSelected());
			customers.addCustomer(c);
			
			//Add Customer to list
			customerList.addElement(name.getText());
			sortDisplay();
		} else {
			Customer updated = customers.get(customerDisplay.getSelectedValue());
			
			//If name already exists, invalid
			if (customerList.contains(name.getText()) && !updated.getName().equals(name.getText())) {
				invalid();
				return;
			}
			
			//Update customer info
			customerList.removeElement(updated.getName());
	
			updated.setName(name.getText());
			updated.setEmail(email.getText());
			updated.setDog(dog.isSelected());
			updated.setCat(cat.isSelected());
			updated.setBird(bird.isSelected());
			updated.setFish(fish.isSelected());
			updated.setOther(other.isSelected());
			updated.setAmount(a);
			updated.setLocation((String) location.getSelectedItem());
			updated.setNotes(notes.getText());
			
			customerList.addElement(name.getText());
			sortDisplay();	
		}
		
		customerDisplay.setSelectedValue(name.getText(), true);
		success();
	}
	
	private void deleteCustomer() {
		String n = customerDisplay.getSelectedValue();
		customers.removeCustomer(n);
		customerList.removeElement(n);
		clearFields();
		sortDisplay();
	}
	
	private void displayCustomer() {
		//Get Customer
		displayed = customers.get(customerDisplay.getSelectedValue());
		
		if (displayed != null) {
			//Set Fields
			name.setText(displayed.getName());
			email.setText(displayed.getEmail());
			dog.setSelected(displayed.getDog());
			cat.setSelected(displayed.getCat());
			bird.setSelected(displayed.getBird());
			fish.setSelected(displayed.getFish());
			other.setSelected(displayed.getOther());
			amount.setText(displayed.getAmount());
			location.setSelectedItem(displayed.getLocation());
			notes.setText(displayed.getNotes());
		}

	}
	
	private void invalid() {
		JFrame inv = new JFrame("Invalid");
		inv.setSize(200,100);
		JOptionPane.showMessageDialog(inv, "Invalid Input!", "Invalid", JOptionPane.WARNING_MESSAGE);
	}
	
	private void success() {
		JFrame suc = new JFrame("Success");
		suc.setSize(200,100);
		JOptionPane.showMessageDialog(suc, "Customer Saved!", "Success", JOptionPane.DEFAULT_OPTION);
	}
	
	private void sortDisplay() {
		List<String> temp = Collections.list(customerList.elements());
		Collections.sort(temp);
		customerList.clear();
		for (String s : temp) {
			customerList.addElement(s);
		}
		customerDisplay.setModel(customerList);
	}
	
	public static void main(String args[]) {
		new CustomerManager();
	}
}