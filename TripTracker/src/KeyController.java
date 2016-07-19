    /*
     * Eddie Tang
     * et354@drexel.edu
     * CS338:GUI, Assignment [2], Program [1]
     */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

public class KeyController implements KeyListener{

	Model _model;
	View _view;
	//Flight
			String txtFlightDate = "";
			String txtFlightTime = "";
			String txtAirline = "";
			String txtFlightNumber = "";
			String txtFlightDepCity = "";
			String txtFlightArrivalCity = "";
			String txtFlightArrivalTime = "";
			String txtFlightPrice = "";
			String txtFlightConfirmNum = "";
			
			//Train
			String txtTrainDate = "";
			String txtTrainTime = "";
			String txtTrainCompany = "";
			String txtTrainNum = "";
			String txtTrainDepCity = "";
			String txtTrainArrivalCity = "";
			String txtTrainArrivalTime = "";
			String txtTrainPrice = "";
			String txtTrainConfirmNum = "";
			
			//Car
			String txtCarDate = "";
			String txtCarPickupTime = "";
			String txtCarCompany = "";
			String txtCarCity = "";
			String txtCarLocation = "";
			String txtCarPrice = "";
			String txtCarConfirmNum = "";
	public KeyController(View view, Model model)
	{
		_view = view;
		_model = model;
		_view.addKeyListener(this);
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
		final JComponent source = (JComponent)event.getSource();
		
		txtAirline = _view.cmbAirline.getSelectedItem().toString();
		txtFlightDepCity = _view.cmbFlightDepCity.getSelectedItem().toString();
		txtFlightArrivalCity = _view.cmbFlightArrivalCity.getSelectedItem().toString();
		txtTrainCompany = _view.cmbTrainCompany.getSelectedItem().toString();
		txtTrainDepCity = _view.cmbTrainDepCity.getSelectedItem().toString();
		txtTrainArrivalCity = _view.cmbTrainArrivalCity.getSelectedItem().toString();
		txtCarCompany = _view.cmbCarCompany.getSelectedItem().toString();
		txtCarCity = _view.cmbCarCity.getSelectedItem().toString();
		
		if(_view.rbnFlight.isSelected()){
			if(source.equals(_view.txtFlightDate)){
				txtFlightDate = txtFlightDate + event.getKeyChar();
			} 
			else if(source.equals(_view.txtFlightTime)){
				txtFlightTime = txtFlightTime + event.getKeyChar();
			}
			else if(source.equals(_view.txtFlightNumber)){
				txtFlightNumber = txtFlightNumber + event.getKeyChar();
			}
			else if(source.equals(_view.txtFlightArrivalTime)){
				txtFlightArrivalTime = txtFlightArrivalTime + event.getKeyChar();
			}
			else if(source.equals(_view.txtFlightPrice))
			{
				txtFlightPrice = txtFlightPrice + event.getKeyChar();
			}
			else if(source.equals(_view.txtFlightConfirmNum)){
				txtFlightConfirmNum = txtFlightConfirmNum + event.getKeyChar();
			}
			_view.lblSummary.setText(txtFlightDate + "," + txtFlightTime + "," + txtAirline + "," + txtFlightNumber + "," + txtFlightDepCity + "," + txtFlightArrivalCity + "," + txtFlightArrivalTime + "," + txtFlightPrice + "," + txtFlightConfirmNum);
		}
		else if(_view.rbnTrain.isSelected()){
			if(source.equals(_view.txtTrainDate)){
				txtTrainDate = txtTrainDate + event.getKeyChar();
			}
			else if(source.equals(_view.txtTrainTime)){
				txtTrainTime = txtTrainTime + event.getKeyChar();
			}
			else if(source.equals(_view.txtTrainNum)){
				txtTrainNum = txtTrainNum + event.getKeyChar();
			}
			else if(source.equals(_view.txtTrainArrivalTime)){
				txtTrainArrivalTime = txtTrainArrivalTime + event.getKeyChar();
			}
			else if(source.equals(_view.txtTrainPrice)){
				txtTrainPrice = txtTrainPrice + event.getKeyChar();
			}
			else if(source.equals(_view.txtTrainConfirmNum)){
				txtTrainConfirmNum = txtTrainConfirmNum + event.getKeyChar();
			}
			_view.lblSummary.setText(txtTrainDate + "," + txtTrainTime + "," + txtTrainCompany + "," + txtTrainNum + "," + txtTrainDepCity + "," + txtTrainArrivalCity + "," + txtTrainArrivalTime + "," + txtTrainPrice + "," + txtTrainConfirmNum);
				
		}
		else if(_view.rbnCar.isSelected()){
			if(source.equals(_view.txtCarDate)){
				txtCarDate = txtCarDate + event.getKeyChar();
			}
			else if(source.equals(_view.txtCarPickupTime)){
				txtCarPickupTime = txtCarPickupTime + event.getKeyChar();
			}
			else if(source.equals(_view.txtCarLocation)){
				txtCarLocation = txtCarLocation + event.getKeyChar();
			}
			else if(source.equals(_view.txtCarPrice)){
				txtCarPrice = txtCarPrice + event.getKeyChar();
			}
			else if(source.equals(_view.txtCarConfirmNum)){
				txtCarConfirmNum = txtCarConfirmNum + event.getKeyChar();
			}
			_view.lblSummary.setText(txtCarDate + "," + txtCarPickupTime + "," + txtCarCompany + "," + txtCarCity + "," + txtCarLocation + "," + txtCarPrice + "," + txtCarConfirmNum);	
		}
		UpdateView();
		
		if(checkFields()){
			enableSaveButton();
			enableChangeButton();
		}else{
			disableSaveButton();
			disableChangeButton();
		}
	}

	public void UpdateView(){
		_view.mainFrame.validate();
		_view.mainFrame.repaint();
		_view.mainFrame.pack();
	}
	//checks to make sure fields are valid for enabling buttons
	private boolean checkFields(){
		boolean valid = false; 
		if(!_view.txtFlightDate.getText().equals("") && !_view.txtFlightTime.getText().equals("") && !_view.txtFlightNumber.getText().equals("") && !_view.txtFlightArrivalTime.getText().equals("") && !_view.txtFlightPrice.getText().equals("") && !_view.txtFlightConfirmNum.getText().equals("")){
			valid = true;
		}
		else if(!_view.txtTrainDate.getText().equals("") && !_view.txtTrainTime.getText().equals("") && !_view.txtTrainNum.getText().equals("") && !_view.txtTrainArrivalTime.getText().equals("") && !_view.txtTrainPrice.getText().equals("") && !_view.txtTrainConfirmNum.getText().equals("")){
			valid = true;
		}
		else if(!_view.txtCarDate.getText().equals("") && !_view.txtCarPickupTime.getText().equals("") && !_view.txtCarLocation.getText().equals("") && !_view.txtCarPrice.getText().equals("") && !_view.txtCarConfirmNum.getText().equals("")){
			valid = true;
		}
		return valid;
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
	
	private void disableSaveButton(){
		_view.btnSave.setEnabled(false);
	}
	
	private void disableChangeButton(){
		_view.btnChange.setEnabled(false);
	}
}
