import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.FileDialog;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

class gui{
	public static JFrame frame = new JFrame("Course Project v1");
	public static void main(String[] args){
		System.setProperty("apple.awt.fileDialogForDirectories", "true");
       	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	frame.setSize(300,300);
       	JButton uploadButton = new JButton("Upload File");
       	uploadButton.addActionListener(new ActionListener(){
       		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
   				if (action.equals("upload")) {
      				JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
      				int returnValue = fileChooser.showOpenDialog(null);
            		if (returnValue == JFileChooser.APPROVE_OPTION) {
            			File selectedFile = fileChooser.getSelectedFile();
            			fileUploaded(selectedFile.getName());
            			/*try {
            				System.out.println(selectedFile.getName());
            				System.out.println(selectedFile.getAbsolutePath());
							java.awt.Desktop.getDesktop().open(selectedFile);
						} catch (IOException e1) {
							e1.printStackTrace();
						}*/
            		}
   				}
			}	
       	});
       	uploadButton.setActionCommand("upload");
       	frame.getContentPane().add(uploadButton);
       	frame.setVisible(true);
	}
	public static void fileUploaded(String filename){
		JTextField textField = new JTextField(filename + " uploaded");
		frame.getContentPane().add(textField);
		System.out.println(filename + " added");
	}
}