    /*
     * Eddie Tang
     * et354@drexel.edu
     * CS338:GUI, Assignment [2], Program [1]
     */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;

public class View {
	
	public static final DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
	public static final DateFormat time = new SimpleDateFormat("HH:mm");
	public JFrame mainFrame;
	public JPanel menuLayout; 
	public JPanel buttonLayout;
	public JPanel radioButtonLayout;
	public JPanel formattingLayout;
	public JLabel lblTitle;
	public JList masterList;
	public Vector<String> list;
	private Vector<String> airlines;
	private Vector<String> DepCity;
	private Vector<String> ArrivalCity;
	private Vector<String> trainCompanies;
	private Vector<String> carCompanies;
	
	public JButton btnSave;
	public JButton btnChange;
	public JButton btnRemove;
	
	public JLabel lblSummaryTitle;
	public JLabel lblSummary;
	
	//Declare flight controls
	public JLabel lblFlightDate;
	public JLabel lblFlightTime;
	public JLabel lblAirline;
	public JLabel lblFlightNumber;
	public JLabel lblFlightDepCity;
	public JLabel lblFlightArrivalCity;
	public JLabel lblFlightArrivalTime;
	public JLabel lblFlightPrice;
	public JLabel lblFlightConfirmNum;
	
	public JFormattedTextField txtFlightDate;
	public JFormattedTextField txtFlightTime;
	public JComboBox cmbAirline;
	public JTextField txtFlightNumber;
	public JComboBox cmbFlightDepCity;
	public JComboBox cmbFlightArrivalCity;
	public JFormattedTextField txtFlightArrivalTime;
	public JTextField txtFlightPrice;
	public JTextField txtFlightConfirmNum;
	
	//Declare Train controls
	public JLabel lblTrainDate;
	public JLabel lblTrainTime;
	public JLabel lblTrainCompany;
	public JLabel lblTrainNum;
	public JLabel lblTrainDepCity;
	public JLabel lblTrainArrivalCity;
	public JLabel lblTrainArrivalTime;
	public JLabel lblTrainPrice;
	public JLabel lblTrainConfirmNum;
	
	public JFormattedTextField txtTrainDate;
	public JFormattedTextField txtTrainTime;
	public JComboBox cmbTrainCompany;
	public JTextField txtTrainNum;
	public JComboBox cmbTrainDepCity;
	public JComboBox cmbTrainArrivalCity;
	public JFormattedTextField txtTrainArrivalTime;
	public JTextField txtTrainPrice;
	public JTextField txtTrainConfirmNum;

	//Declare Car controls
	public JLabel lblCarDate;
	public JLabel lblCarPickupTime;
	public JLabel lblCarCompany;
	public JLabel lblCarCity;
	public JLabel lblCarLocation;
	public JLabel lblCarPrice;
	public JLabel lblCarConfirmNum;
	
	public JFormattedTextField txtCarDate;
	public JFormattedTextField txtCarPickupTime;
	public JComboBox cmbCarCompany;
	public JComboBox cmbCarCity;
	public JTextField txtCarLocation;
	public JTextField txtCarPrice;
	public JTextField txtCarConfirmNum;
	 
	//RadioButtons for Adding trips
	public ButtonGroup radios;
	public JRadioButton rbnFlight;
	public JRadioButton rbnTrain;
	public JRadioButton rbnCar;
	
	public View(){
		list = new Vector<String>();
		createControls();
		mainFrame.setVisible(true);
	}
	
	public void createControls(){
		mainFrame = new JFrame();
		menuLayout = new JPanel();
		buttonLayout = new JPanel();
		radioButtonLayout = new JPanel();
		formattingLayout = new JPanel();
		
		lblTitle = new JLabel("Add:");
		
		masterList = new JList(list);
		masterList.setVisibleRowCount(5);
		masterList.setFixedCellHeight(15);
		masterList.setFixedCellWidth(100);
		
		airlines = new Vector<String>();
		airlines.add("American Airlines");
		airlines.add("United Airways");
		airlines.add("SouthWest");
		
		DepCity = new Vector<String>();
		DepCity.add("Philadelphia");
		DepCity.add("New York");
		DepCity.add("San Francisco");
		
		ArrivalCity = new Vector<String>();
		ArrivalCity.add("Washington D.C");
		ArrivalCity.add("Tallahassee");
		ArrivalCity.add("Chicago");
		
		trainCompanies = new Vector<String>();
		trainCompanies.add("Amtrak");
		trainCompanies.add("C2c");
		trainCompanies.add("Crosscountry");
		
		carCompanies = new Vector<String>();
		carCompanies.add("Uber");
		carCompanies.add("Lyft");
		carCompanies.add("Affordable Taxis");
		
		lblSummaryTitle = new JLabel("Summary:");
		lblSummary = new JLabel("");
		
		btnSave = new JButton("Save");
		btnChange = new JButton("Change");
		btnRemove = new JButton("Remove");
		
		//initialize flight controls
		lblFlightDate = new JLabel("Date:");
		lblFlightTime = new JLabel("Time:");
		lblAirline = new JLabel("Airline:");
		lblFlightNumber = new JLabel("Number:");
		lblFlightDepCity = new JLabel("Departure City:");
		lblFlightArrivalCity = new JLabel("Arrival City:");
		lblFlightArrivalTime = new JLabel("Arrival Time");
		lblFlightPrice = new JLabel("Price:");
		lblFlightConfirmNum = new JLabel("Confirmation Number:");
		
		txtFlightDate = new JFormattedTextField(df);
		dateMask(txtFlightDate);
		txtFlightTime = new JFormattedTextField(time);
		timeMask(txtFlightTime);
		cmbAirline = new JComboBox(airlines);
		txtFlightNumber = new JTextField();
		cmbFlightDepCity = new JComboBox(DepCity);
		cmbFlightArrivalCity = new JComboBox(ArrivalCity);
		txtFlightArrivalTime = new JFormattedTextField(time);
		timeMask(txtFlightArrivalTime);
		txtFlightPrice = new JFormattedTextField();
		txtFlightConfirmNum = new JTextField();
		
		//initialize Train controls
		lblTrainDate = new JLabel("Date:");
		lblTrainTime = new JLabel("Time:");
		lblTrainCompany = new JLabel("Company:");
		lblTrainNum = new JLabel("Number:");
		lblTrainDepCity = new JLabel("Departure City:");
		lblTrainArrivalCity = new JLabel("Arrival City:");
		lblTrainArrivalTime = new JLabel("Arrival Time:");
		lblTrainPrice = new JLabel("Price:");
		lblTrainConfirmNum = new JLabel("Confirmation Number:");
		
		txtTrainDate = new JFormattedTextField(df);
		dateMask(txtTrainDate);
		txtTrainTime = new JFormattedTextField(time);
		timeMask(txtTrainTime);
		cmbTrainCompany = new JComboBox(trainCompanies);
		txtTrainNum = new JTextField();
		cmbTrainDepCity = new JComboBox(DepCity);
		cmbTrainArrivalCity = new JComboBox(ArrivalCity);
		txtTrainArrivalTime = new JFormattedTextField(time);
		timeMask(txtTrainArrivalTime);
		txtTrainPrice = new JTextField();
		txtTrainConfirmNum = new JTextField();
		
		//Initialize Car Controls
		lblCarDate = new JLabel("Date:");
		lblCarPickupTime = new JLabel("Pickup Time:");
		lblCarCompany = new JLabel("Company:");
		lblCarCity = new JLabel("City:");
		lblCarLocation = new JLabel("Location:");
		lblCarPrice = new JLabel("Price:");
		lblCarConfirmNum = new JLabel("Confirmation Number:");
		
		txtCarDate = new JFormattedTextField(df);
		dateMask(txtCarDate);
		txtCarPickupTime = new JFormattedTextField(time);
		timeMask(txtCarPickupTime);
		cmbCarCompany = new JComboBox(carCompanies);
		cmbCarCity = new JComboBox(DepCity);
		txtCarLocation = new JTextField();
		txtCarPrice = new JTextField();
		txtCarConfirmNum = new JTextField();
		
		rbnFlight = new JRadioButton("Flight");
		rbnTrain = new JRadioButton("Train");
		rbnCar = new JRadioButton("Car");
		radios = new ButtonGroup();
		radios.add(rbnFlight);
		radios.add(rbnTrain);
		radios.add(rbnCar);
		
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setTitle("TripTracker");
		
		menuLayout.setLayout(new GridLayout());
		buttonLayout.setLayout(new GridLayout());
		
		buttonLayout.add(btnSave);
		buttonLayout.add(btnChange);
		buttonLayout.add(btnRemove);
		
		formattingLayout.setLayout(new GridLayout(0,1));
		
		radioButtonLayout.setLayout(new GridLayout(0,1));
		radioButtonLayout.add(lblTitle);
		radioButtonLayout.add(rbnFlight);
		radioButtonLayout.add(rbnTrain);
		radioButtonLayout.add(rbnCar);
		
		formattingLayout.add(radioButtonLayout);
		formattingLayout.add(lblSummaryTitle);
		formattingLayout.add(lblSummary);
		
		mainFrame.add(masterList, BorderLayout.NORTH);
		mainFrame.add(formattingLayout, BorderLayout.WEST);
		mainFrame.add(menuLayout, BorderLayout.CENTER);
		mainFrame.add(buttonLayout, BorderLayout.SOUTH);
		
		//mainFrame.add(createLayout());
		mainFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		mainFrame.pack();
	}
	
	//Creates the layout for the Flight menu
	public JPanel FlightMenu(){
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0,2));
		
		mainPanel.add(lblFlightDate);
		mainPanel.add(txtFlightDate);
		mainPanel.add(lblFlightTime);
		mainPanel.add(txtFlightTime);
		mainPanel.add(lblAirline);
		mainPanel.add(cmbAirline);
		mainPanel.add(lblFlightNumber);
		mainPanel.add(txtFlightNumber);
		mainPanel.add(lblFlightDepCity);
		mainPanel.add(cmbFlightDepCity);
		mainPanel.add(lblFlightArrivalCity);
		mainPanel.add(cmbFlightArrivalCity);
		mainPanel.add(lblFlightArrivalTime);
		mainPanel.add(txtFlightArrivalTime);
		mainPanel.add(lblFlightPrice);
		mainPanel.add(txtFlightPrice);
		mainPanel.add(lblFlightConfirmNum);
		mainPanel.add(txtFlightConfirmNum);
		
		return mainPanel;
	} 
	
	//Creates the layout for the Train menu
	public JPanel TrainMenu(){
		JPanel mainPanel = new JPanel();
		
		mainPanel.setLayout(new GridLayout(0,2));
		
		mainPanel.add(lblTrainDate);
		mainPanel.add(txtTrainDate);
		mainPanel.add(lblTrainTime);
		mainPanel.add(txtTrainTime);
		mainPanel.add(lblTrainCompany);
		mainPanel.add(cmbTrainCompany);
		mainPanel.add(lblTrainNum);
		mainPanel.add(txtTrainNum);
		mainPanel.add(lblTrainDepCity);
		mainPanel.add(cmbTrainDepCity);
		mainPanel.add(lblTrainArrivalCity);
		mainPanel.add(cmbTrainArrivalCity);
		mainPanel.add(lblTrainArrivalTime);
		mainPanel.add(txtTrainArrivalTime);
		mainPanel.add(lblTrainPrice);
		mainPanel.add(txtTrainPrice);
		mainPanel.add(lblTrainConfirmNum);
		mainPanel.add(txtTrainConfirmNum);
		
		return mainPanel;
	}
	
	//Creates te layout for the Car menu
	public JPanel CarMenu(){
		JPanel mainPanel = new JPanel();
		
		mainPanel.setLayout(new GridLayout(0,2));
		
		mainPanel.add(lblCarDate);
		mainPanel.add(txtCarDate);
		mainPanel.add(lblCarPickupTime);
		mainPanel.add(txtCarPickupTime);
		mainPanel.add(lblCarCompany);
		mainPanel.add(cmbCarCompany);
		mainPanel.add(lblCarCity);
		mainPanel.add(cmbCarCity);
		mainPanel.add(lblCarLocation);
		mainPanel.add(txtCarLocation);
		mainPanel.add(lblCarPrice);
		mainPanel.add(txtCarPrice);
		mainPanel.add(lblCarConfirmNum);
		mainPanel.add(txtCarConfirmNum);
		
		return mainPanel;
	}
	
	//adds a action controller for selected controls
	public void addController(Controller controller){
		btnSave.addActionListener(controller);
		btnChange.addActionListener(controller);
		btnRemove.addActionListener(controller);
		rbnFlight.addActionListener(controller);
		rbnTrain.addActionListener(controller);
		rbnCar.addActionListener(controller);
		txtFlightDate.addActionListener(controller);
		
	}
	//add list controller for list controls
	public void addListController(ListController listcontroller){
		masterList.addListSelectionListener(listcontroller);
	}
	//add key controller for key controls
	public void addKeyListener(KeyController keycontroller){
		txtFlightDate.addKeyListener(keycontroller);
		txtFlightTime.addKeyListener(keycontroller);
		txtFlightNumber.addKeyListener(keycontroller);
		txtFlightArrivalTime.addKeyListener(keycontroller);
		txtFlightPrice.addKeyListener(keycontroller);
		txtFlightConfirmNum.addKeyListener(keycontroller);
		
		txtTrainDate.addKeyListener(keycontroller);
		txtTrainTime.addKeyListener(keycontroller);
		txtTrainNum.addKeyListener(keycontroller);
		txtTrainArrivalTime.addKeyListener(keycontroller);
		txtTrainPrice.addKeyListener(keycontroller);
		txtTrainConfirmNum.addKeyListener(keycontroller);
		
		txtCarDate.addKeyListener(keycontroller);
		txtCarPickupTime.addKeyListener(keycontroller);
		txtCarLocation.addKeyListener(keycontroller);
		txtCarPrice.addKeyListener(keycontroller);
		txtCarConfirmNum.addKeyListener(keycontroller);
	}

	private void dateMask(JFormattedTextField tf)
	{
		try{
			MaskFormatter dm = new MaskFormatter("##/##/####");
			dm.install(tf);
		}catch(ParseException ex){
			
		}
	}
	
	private void timeMask(JFormattedTextField tf){
		try{
			MaskFormatter cm = new MaskFormatter("##:##");
			cm.install(tf);
		}catch(ParseException ex){
			
		}
	}
}
