/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eliminarasterisco;

import Utiles.FX.VisualFX;
import Utiles.MetodosUtiles.MetodosUtiles;
import Utiles.PW.UtilesHTLM;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.scene.web.skin.HTMLEditorSkin;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.function.Predicate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.web.HTMLEditor;

public class VentanaController implements Initializable {

    @FXML
    private HTMLEditor Thtml;

    @FXML
    private JFXTextArea T;

    @FXML
    private JFXButton BE;

    @FXML
    private JFXButton BH;
    @FXML
    private JFXButton BEliminarNumero;
    @FXML
    private JFXButton BCopiar;
    @FXML
    private JFXButton BTA;
    
     @FXML
    private JFXButton BVerHTMl;
      @FXML
    private JFXButton BVaciar;
       @FXML
    private JFXButton BChar;
       @FXML
    private JFXTextField SPChar;

    @FXML
    private JFXTextField TChar;
     @FXML
    private JFXButton BCharss;
     
     @FXML
    private JFXTextField TPonerDelante;
     @FXML
    private JFXButton BPonerDelante;
     @FXML
    private JFXButton BQuitarHtmlYPonerDelante;
     @FXML
     void apretoQuitarHtmlYPonerDelante(ActionEvent event) {
            String A[]=eliminarInicio(c -> c == '*', true);
            
            String a=TPonerDelante.getText();
            //T.getText().split("\n");
            for (int i = 0; i < A.length; i++) {
                
             A[i]=a+" "+A[i];
            }
            setAll(A);
     }
     @FXML
     void apretoPonerDelante(ActionEvent event) {
            String a=TPonerDelante.getText();
            String A[]=T.getText().split("\n");
            for (int i = 0; i < A.length; i++) {
                
             A[i]=a+" "+A[i];
            }
            setAll(A);
//            Scanner s = new Scanner(T.getText());
//        boolean cuerpo = false;
//        while (s.hasNextLine()) {
//            String a = s.nextLine();
//        
//        }
     }
     
  @FXML
    void apretoBCharss(ActionEvent event) {
String a="";
      for (int i = 0; i < 255; i++) {
          a+=i+" "+(char)i+"\n";
      }
      T.setText(a);
    }
@FXML
    void apretoBChar(ActionEvent event) {
        //System.out.println("algo");
        //System.out.println("((int)SPChar.getValue())="+((int)SPChar.getValue()));
        int f=MetodosUtiles.inT(SPChar.getText());
        //System.out.println("f="+f);
        char s=(char) f;
       // System.out.println("s="+s);
        String a=s+"";
       // System.out.println("a="+a);
TChar.setText(a);
    }
@FXML
    void apretoBVaciar(ActionEvent event) {
T.setText("");
Thtml.setHtmlText("");
    }
@FXML
    void apretoBVerHTML(ActionEvent event) {
T.setText(Thtml.getHtmlText());
    }

    @FXML
    void apretoBTA(ActionEvent event) {
        String H1[] = {"<html>", "<head>", "</head>", "<body>"}, H2[] = {"</body>", "</html>"};
        LinkedList<String> l = new LinkedList<>();
        Scanner s = new Scanner(T.getText());
        while (s.hasNextLine()) {
            String a = s.nextLine();
            if (!a.isEmpty()) {
                l.add(a.replace("información", "in for ma cion"));
            }
        }
        Thtml.setHtmlText("");
        setAll(H1, "");
        add(l.toArray(new String[0]));
        add(H2);

//        Thtml.setHtmlText(T.getText().replace("información", "infor ma cion"));
    }

    @FXML
    void apretoCopiar(ActionEvent event) {
        T.setText("");
        T.paste();
    }

    private String[] eliminarInicio(Predicate<Character> p, boolean eliminarCuerpos) {
        String H1[] = {"<html>", "<head>", "</head>", "<body>"}, H2[] = {"</body>", "</html>"};
        LinkedList<String> l = new LinkedList<>();
        Scanner s = new Scanner(T.getText());
        boolean cuerpo = false;
        while (s.hasNextLine()) {
            String a = s.nextLine();
            a=UtilesHTLM.deleteAllTags(a,"html","head","body","br","ul","ol","li","b");
//            System.out.println("a="+a);
            if (!a.isEmpty()) {
                for (int i = 0; i < a.length(); i++) {
                    char c = a.charAt(i);
                    if (c == ' ') {
                        continue;
                    }

                    if (p.test(c)) {
                        // if (c >= '0' && c <= '9') {
                        a = a.substring(i-- + 1);
                        continue;
//                        System.out.println("a 2="+a);
                    }
                    break;
                }
                if (eliminarCuerpos) {
                    String b = "";
                    for (int i = 0; i < a.length(); i++) {
                        char c = a.charAt(i);
                        if (cuerpo) {
                            if (c == '}') {
                                cuerpo = false;
                            }
                            continue;
                        }
                        if (c == '{') {
                            cuerpo = true;
                            continue;
                        }
                        b += c + "";
                    }
                    a = b;
                }

                l.add(a);
            }
            //   a = (!a.isEmpty() && a.charAt(0) == '*') ? a.substring(1) : a;

        }
        Thtml.setHtmlText("");
        setAll(H1, "");
        add(l.toArray(new String[0]));
        add(H2);
        System.out.println("apreto 1");
        
        String B[]=l.toArray(new String[0]);
        String b="";
        for (int i = 0; i < 10; i++) {
            b+="\n"+B[i];
        }
        return b.split("\n");
    }

    @FXML
    void apretoEliminarNumero(ActionEvent event) {
        eliminarInicio(c -> c >= '0' && c <= '9', false);
    }

    @FXML
    void apretarEliminarAsterisco(ActionEvent event) {
        LinkedList<String> l = new LinkedList<>();
        Scanner s = new Scanner(T.getText());
        while (s.hasNextLine()) {
            String a = s.nextLine();
//            System.out.println("a="+a);
            if (!a.isEmpty()) {
                for (int i = 0; i < a.length(); i++) {
                    char c = a.charAt(i);
                    if (c == ' ') {
                        continue;
                    }
                    if (c == '*') {
                        a = a.substring(i + 1);
//                        System.out.println("a 2="+a);
                    }
                }
                l.add(a);
            }
            //   a = (!a.isEmpty() && a.charAt(0) == '*') ? a.substring(1) : a;

        }
        Thtml.setHtmlText("");
        String A[] = l.toArray(new String[0]);
//        System.out.println(Arrays.toString(A));
        add(A);
        System.out.println("apreto 2");
    }

    @FXML
    void apretarEliminarAsteriscoYHtml(ActionEvent event) {
        eliminarInicio(c -> c == '*', true);
//        String H1[] = {"<html>", "<head>", "</head>", "<body>"}, H2[] = {"</body>", "</html>"};
//        LinkedList<String> l = new LinkedList<>();
//        Scanner s = new Scanner(T.getText());
//        boolean cuerpo = false;
//        while (s.hasNextLine()) {
//            String a = s.nextLine();
////            System.out.println("a="+a);
//            if (!a.isEmpty()) {
//                for (int i = 0; i < a.length(); i++) {
//                    char c = a.charAt(i);
//                    if (c == ' ') {
//                        continue;
//                    }
//                    if (c == '*') {
//                        a = a.substring(i + 1);
////                        System.out.println("a 2="+a);
//                    }
//                }
//                String b = "";
//                for (int i = 0; i < a.length(); i++) {
//                    char c = a.charAt(i);
//                    if (cuerpo) {
//                        if (c == '}') {
//                            cuerpo = false;
//                        }
//                        continue;
//                    }
//                    if (c == '{') {
//                        cuerpo = true;
//                        continue;
//                    }
//                    b += c + "";
//                }
//                l.add(b);
//            }
//            //   a = (!a.isEmpty() && a.charAt(0) == '*') ? a.substring(1) : a;
//
//        }
//        Thtml.setHtmlText("");
//        add(H1);
//        add(l.toArray(new String[0]));
//        add(H2);
//        System.out.println("apreto 1");
    }

    private void add(String A[]) {
        setAll(Thtml.getHtmlText(), A, "<br>");
//        String texto = Thtml.getHtmlText();
//        for (int i = 0; i < A.length; i++) {
//            texto += A[i] + "\n";
//            
//        }
//        Thtml.setHtmlText(texto);
    }

    private void setAll(String A[], String salto) {
        setAll("", A, salto);
    }

    private void setAll(String texto, String A[], String salto) {
        for (int i = 0; i < A.length; i++) {
            texto += A[i] + salto;

        }
        Thtml.setHtmlText(texto);
    }

    private void setAll(String A[]) {
        setAll("", A, "<br>");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//Utiles.FX.VisualFX.iniSpinnerInteger(SPChar, 0, 255);

//SPChar.setEditable(true);
Utiles.FX.VisualFX.soloNumeros(SPChar);
//SPChar.getEditor().setOnKeyReleased(v->{
//    char a=v.getCharacter().charAt(0);
//if(MetodosUtiles.esCharNumero(a)){
//    System.out.println("escribe");
//SPChar.getEditor().setText(SPChar.getEditor().getText()+a);
//}
//});
    }
}
