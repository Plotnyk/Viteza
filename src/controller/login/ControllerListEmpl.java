package controller.login;

import service.ServiceInterface;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ServiceInterfaceImpl;

/**
 * Created by Женя on 10.11.2017.
 */
public class ControllerListEmpl {
        private ServiceInterface serviceInterface;

        private ObservableList<User> observableList;

        @FXML private TextField fldName;
        @FXML private TextField fldSurname;
        @FXML private TextField fldBirdth;
        @FXML private TextField fldBeginWork;
        @FXML private TextField fldPosition;
        @FXML private TableColumn<User, Long> colId;
        @FXML private TableColumn<User, String> colSurname;
        @FXML private TableColumn<User, String> colName;
        @FXML private TableColumn<User, Integer> colBirdth;
        @FXML private TableColumn<User, Integer> colBegin;
        @FXML private TableColumn<User, String> colPosition;
        @FXML private TableView<User> fldTabView;


        @FXML
        private void initialize(){
            serviceInterface = new ServiceInterfaceImpl();

            observableList = FXCollections.observableArrayList(serviceInterface.getAll());
            colId.setCellValueFactory(new PropertyValueFactory<User,Long>("ID"));
            colName.setCellValueFactory(new PropertyValueFactory<User,String>("NAME"));
            colSurname.setCellValueFactory(new PropertyValueFactory<User,String>("SURNAME"));
            colBegin.setCellValueFactory(new PropertyValueFactory<User,Integer>("BEGIN"));
            colBirdth.setCellValueFactory(new PropertyValueFactory<User,Integer>("BIRDTH_DATE"));
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
            serviceInterface.delete(fldTabView.getSelectionModel().getSelectedItem());
//        Здається правильно, перевіриш коли будеш збирати все разом
        }

        @FXML
        private void exitApp(){
            System.exit(0);
        }
}
