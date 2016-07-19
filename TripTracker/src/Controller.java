    /*
     * Eddie Tang
     * et354@drexel.edu
     * CS338:GUI, Assignment [2], Program [1]
     */

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

public class Controller implements java.awt.event.ActionListener{
	
	View _view;
	Model _model;
	ListController _listController;
	KeyController _keyController;
	
	public Controller(){
		_view = new View();
		_model = new Model();
		_listController = new ListController(_view, _model);
		_keyController = new KeyController(_view, _model);
		startup();
	}
	
	@SuppressWarnings("deprecation")
	public void startup(){
		_view.addController(this);
		disableButtons();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		final JComponent source = (JComponent)e.getSource();
		if(source.equals(_view.btnSave)){
			//airplane info
			String newData = "";
			if(_view.rbnFlight.isSelected()){		
				_model.addToTrackingList(0);
				newData = _model.createSave(new FlightMenu(), _view.txtFlightDate.getText(), _view.txtFlightTime.getText(), _view.cmbAirline.getSelectedItem().toString(), _view.txtFlightNumber.getText(), _view.cmbFlightDepCity.getSelectedItem().toString(), _view.cmbFlightArrivalCity.getSelectedItem().toString(), _view.txtFlightArrivalTime.getText(), _view.txtFlightPrice.getText(), _view.txtFlightConfirmNum.getText());
			}
			else if(_view.rbnTrain.isSelected()){
				_model.addToTrackingList(1);
				newData = _model.createSave(new TrainMenu(), _view.txtTrainDate.getText(), _view.txtTrainTime.getText(), _view.cmbTrainCompany.getSelectedItem().toString(), _view.txtTrainNum.getText(), _view.cmbTrainDepCity.getSelectedItem().toString(), _view.cmbTrainArrivalCity.getSelectedItem().toString(), _view.txtTrainArrivalTime.getText(), _view.txtTrainPrice.getText(), _view.txtTrainConfirmNum.getText());
			}
			else if(_view.rbnCar.isSelected()){
				_model.addToTrackingList(2);
				newData = _model.createSave(new CarMenu(), _view.txtCarDate.getText(), _view.txtCarPickupTime.getText(), _view.cmbCarCompany.getSelectedItem().toString(), _view.cmbCarCity.getSelectedItem().toString(), _view.txtCarLocation.getText(), _view.txtCarPrice.getText(), _view.txtCarConfirmNum.getText());
			}
			_view.list.add(newData);
			
			disableButtons();

		}
		else if(source.equals(_view.btnChange)){
			int type = _model.getType(_view.masterList.getSelectedIndex());
			String saveData = "";
			if(type == 0){
				saveData = _model.createSave(new FlightMenu(), _view.txtFlightDate.getText(), _view.txtFlightTime.getText(), _view.cmbAirline.getSelectedItem().toString(), _view.txtFlightNumber.getText(), _view.cmbFlightDepCity.getSelectedItem().toString(), _view.cmbFlightArrivalCity.getSelectedItem().toString(), _view.txtFlightArrivalTime.getText(), _view.txtFlightPrice.getText(), _view.txtFlightConfirmNum.getText());
			}
			else if(type == 1){
				saveData = _model.createSave(new TrainMenu(), _view.txtTrainDate.getText(), _view.txtTrainTime.getText(), _view.cmbTrainCompany.getSelectedItem().toString(), _view.txtTrainNum.getText(), _view.cmbTrainDepCity.getSelectedItem().toString(), _view.cmbTrainArrivalCity.getSelectedItem().toString(), _view.txtTrainArrivalTime.getText(), _view.txtTrainPrice.getText(), _view.txtTrainConfirmNum.getText());
			}
			else if(type == 2){
				saveData = _model.createSave(new CarMenu(), _view.txtCarDate.getText(), _view.txtCarPickupTime.getText(), _view.cmbCarCompany.getSelectedItem().toString(), _view.cmbCarCity.getSelectedItem().toString(), _view.txtCarLocation.getText(), _view.txtCarPrice.getText(), _view.txtCarConfirmNum.getText());
			}
			_view.list.setElementAt(saveData, _view.masterList.getSelectedIndex());
			_view.masterList.clearSelection();
			disableButtons();
		}
		else if(source.equals(_view.btnRemove)){
			_view.list.remove(_view.masterList.getSelectedIndex());
			_model.removeFromTrackingList(_view.masterList.getSelectedIndex());
			_view.masterList.clearSelection();
			_view.radios.clearSelection();
			disableButtons();
		}
		else if(source.equals(_view.rbnFlight)){
			_view.menuLayout.removeAll();
			_view.menuLayout.revalidate();
			_view.menuLayout.repaint();
			_view.menuLayout.add(_view.FlightMenu());
		}
		else if(source.equals(_view.rbnTrain)){
			_view.menuLayout.removeAll();
			_view.menuLayout.revalidate();
			_view.menuLayout.repaint();
			_view.menuLayout.add(_view.TrainMenu());
		}
		else if(source.equals(_view.rbnCar)){
			_view.menuLayout.removeAll();
			_view.menuLayout.revalidate();
			_view.menuLayout.repaint();
			_view.menuLayout.add(_view.CarMenu());
		}
		clearComponents();
		
		UpdateView();
	}
	
	public void UpdateView(){
		_view.mainFrame.validate();
		_view.mainFrame.repaint();
		_view.mainFrame.pack();
	}
	//clears out all values so user can get a fresh screen
	public void clearComponents(){
		_view.txtFlightDate.setText("");
		_view.txtFlightTime.setText("");
		_view.cmbAirline.setSelectedIndex(0);
		_view.txtFlightNumber.setText("");
		_view.cmbFlightDepCity.setSelectedIndex(0);
		_view.cmbFlightArrivalCity.setSelectedIndex(0);
		_view.txtFlightArrivalTime.setText("");
		_view.txtFlightPrice.setText("");
		_view.txtFlightConfirmNum.setText("");
		
		_view.txtTrainDate.setText("");
		_view.txtTrainTime.setText("");
		_view.cmbTrainCompany.setSelectedIndex(0);
		_view.txtTrainNum.setText("");
		_view.cmbTrainDepCity.setSelectedIndex(0);
		_view.cmbTrainArrivalCity.setSelectedIndex(0);
		_view.txtTrainArrivalTime.setText("");
		_view.txtTrainPrice.setText("");
		_view.txtTrainConfirmNum.setText("");
		
		_view.txtCarDate.setText("");
		_view.txtCarPickupTime.setText("");
		_view.cmbCarCompany.setSelectedIndex(0);
		_view.cmbCarCity.setSelectedIndex(0);
		_view.txtCarLocation.setText("");
		_view.txtCarPrice.setText("");
		_view.txtCarConfirmNum.setText("");
		
		_view.lblSummary.setText("");
		
	}
	
	private void disableButtons(){
		_view.btnChange.setEnabled(false);
		_view.btnSave.setEnabled(false);
		_view.btnRemove.setEnabled(false);
	}
	
	private void enableSaveButton(){
		_view.btnSave.setEnabled(true);
	}
	
	private void enableChangeButton(){
		_view.btnChange.setEnabled(true);
	}
	
	private void enableRemoveButton(){
		_view.btnRemove.setEnabled(true);
	}
}
