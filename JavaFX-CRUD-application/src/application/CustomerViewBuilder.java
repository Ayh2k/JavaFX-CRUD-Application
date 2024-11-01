package application;

import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class CustomerViewBuilder implements Builder<Region> {
	
	private final CustomerModel model;
	private final Runnable saveHandler;
	
    public CustomerViewBuilder(CustomerModel model, Runnable saveHandler) {
        this.model = model;
        this.saveHandler = saveHandler;
    }

    @Override
    public Region build() {
        BorderPane results = new BorderPane();
        
        results.setTop(headingLabel("Customer Information"));
        results.setCenter(createCentre());
        results.setBottom(createButtons());
        
        return results;
    }
    
    private Node createCentre() {
    	VBox vbox = new VBox(6, accountBox(), nameBox());
    	vbox.setPadding(new Insets(20));
    	return vbox;
    }
    
    private Node accountBox() {
    	return new HBox(6,promptLabel("Account #:"), boundTextField(model.accountNumberProperty()));
	}

	private Node nameBox() {
        return new HBox(6, promptLabel("Name:"), boundTextField(model.customerNameProperty()));
    }
	
	private Node boundTextField(StringProperty boundProperty) {
    	TextField textField = new TextField();
    	textField.textProperty().bindBidirectional(boundProperty);
    	return textField;
	}
	
    
    private Node createButtons() {
    	Button btnSave = new Button("Save");
    	
    	// Lambda function that calls the saveHandler's run() method when the button is clicked.
    	btnSave.setOnAction(evt -> saveHandler.run());
    	
    	HBox results = new HBox(10,btnSave);
    	results.setAlignment(Pos.CENTER_RIGHT);
    	
    	return results;
    }
	
	private Node promptLabel(String contents) {
	    return styledLabel(contents, "prompt-label");
	    
	}
	
	private Node styledLabel(String contents, String styleClass) {
        Label label = new Label(contents);
        label.getStyleClass().add(styleClass);
        return label;
    }
	
	private Node headingLabel(String contents) {
		return styledLabel(contents, "heading-label");
		
	}
}
