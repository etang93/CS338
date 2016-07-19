    /*
     * Eddie Tang
     * et354@drexel.edu
     * CS338:GUI, Assignment [2], Program [1]
     */
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListController implements ListSelectionListener{

	View _view;
	Model _model;
	
	public ListController(View view, Model model){
		_view = view;
		_model = model;
		_view.addListController(this);
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		final JList source = (JList)e.getSource();
		if(!source.getValueIsAdjusting()){
			if(source.equals(_view.masterList)){
				if(!source.isSelectionEmpty()){
					ArrayList<String> data = _model.loadData(source.getSelectedIndex(), source.getSelectedValue().toString());
					String type = data.get(data.size()-1);
					if(type.equals("Flight")){
						_view.menuLayout.removeAll();
						
						_view.txtFlightDate.setText(data.get(0));
						_view.txtFlightTime.setText(data.get(1));
						_view.cmbAirline.setSelectedItem(data.get(2));
						_view.txtFlightNumber.setText(data.get(3));
						_view.cmbFlightDepCity.setSelectedItem(data.get(4));
						_view.cmbFlightArrivalCity.setSelectedItem(data.get(5));
						_view.txtFlightArrivalTime.setText(data.get(6));
						_view.txtFlightPrice.setText(data.get(7));
						_view.txtFlightConfirmNum.setText(data.get(8));
						
						_view.radios.clearSelection();
						_view.rbnFlight.setSelected(true);
						
						_view.menuLayout.revalidate();
						_view.menuLayout.repaint();
						_view.menuLayout.add(_view.FlightMenu());
					}
					else if(type.equals("Train"))
					{
						_view.menuLayout.removeAll();
						
						_view.txtTrainDate.setText(data.get(0));
						_view.txtTrainTime.setText(data.get(1));
						_view.cmbTrainCompany.setSelectedItem(data.get(2));
						_view.txtTrainNum.setText(data.get(3));
						_view.cmbTrainDepCity.setSelectedItem(data.get(4));
						_view.cmbTrainArrivalCity.setSelectedItem(data.get(5));
						_view.txtTrainArrivalTime.setText(data.get(6));
						_view.txtTrainPrice.setText(data.get(7));
						_view.txtTrainConfirmNum.setText(data.get(8));
						
						_view.radios.clearSelection();
						_view.rbnTrain.setSelected(true);
						
						_view.menuLayout.revalidate();
						_view.menuLayout.repaint();
						_view.menuLayout.add(_view.TrainMenu());
					}
					else if (type.equals("Car"))
					{
						_view.menuLayout.removeAll();
						
						_view.txtCarDate.setText(data.get(0));
						_view.txtCarPickupTime.setText(data.get(1));
						_view.cmbCarCompany.setSelectedItem(data.get(2));
						_view.cmbCarCity.setSelectedItem(data.get(3));
						_view.txtCarLocation.setText(data.get(4));
						_view.txtCarPrice.setText(data.get(5));
						_view.txtCarConfirmNum.setText(data.get(6));
						
						_view.radios.clearSelection();
						_view.rbnCar.setSelected(true);
						
						_view.menuLayout.revalidate();
						_view.menuLayout.repaint();
						_view.menuLayout.add(_view.CarMenu());
					}
					
					enableChangeButton();
					
					enableRemoveButton();
				}
			}
		}
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
