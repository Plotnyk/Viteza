package controller.login;

import service.ServiceEmployee;
import entity.User;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ServiceEmployeeImpl;

import java.util.Date;

/**
 * Created by Женя on 10.11.2017.
 */
public class ControllerListEmpl {
        private ServiceEmployee serviceInterface;

        private ObservableList<User> observableList;

        @FXML private TextField fldName;
        @FXML private TextField fldSurname;
        @FXML private TextField fldBirdth;
        @FXML private TextField fldBeginWork;
        @FXML private TextField fldPosition;
        @FXML private TableColumn<User, Long> colId;
        @FXML private TableColumn<User, String> colSurname;
        @FXML private TableColumn<User, String> colName;
        @FXML private TableColumn<User, Date> colBirdth;
        @FXML private TableColumn<User, Date> colBegin;
        @FXML private TableColumn<User, String> colPosition;
        @FXML private TableView<User> fldTabView;


        @FXML
        private void initialize(){
            serviceInterface = new ServiceEmployeeImpl();

           // observableList = FXCollections.observableArrayList(serviceInterface.getAll());

            colId.setCellValueFactory(new PropertyValueFactory<User,Long>("ID"));
            colName.setCellValueFactory(new PropertyValueFactory<User,String>("NAME"));
            colSurname.setCellValueFactory(new PropertyValueFactory<User,String>("SURNAME"));
            colBegin.setCellValueFactory(new PropertyValueFactory<User,Date>("BEGIN"));
            colBirdth.setCellValueFactory(new PropertyValueFactory<User,Date>("BIRDTH_DATE"));
            colPosition.setCellValueFactory(new PropertyValueFactory<User,String>("POSITION"));
            fldTabView.setItems(observableList);
        }

        @FXML
        private void addWorker(){
            //serviceInterface.create(new User(fldName.getText(), fldSurname.getText(), fldBirdth.getText(), fldBeginWork.getText(), fldPosition.getText()));
//        Тут тобі потрібно повернути ІД з бази після додавання і присвоїти його Юзеру
        }

        @FXML
        private void fire(){
           // serviceInterface.remove(fldTabView.getSelectionModel().getSelectedItem());
//        Здається правильно, перевіриш коли будеш збирати все разом
        }

        @FXML
        private void exitApp(){
            System.exit(0);
        }
}
