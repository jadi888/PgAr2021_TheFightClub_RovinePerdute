package RovinePerdute.unibs.it;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.*;
import java.io.FileInputStream;
import java.util.ArrayList;

public class LeggiDati {

    private ArrayList<Citta> citta;
    private Citta cittaBase;
    private Citta cittaPerduta;

    public void leggiDati(){
            citta = new ArrayList<>();
            XMLInputFactory xmlif = null;
            XMLStreamReader xmlr = null;

            try {
                //aggiungo i file xml
                xmlif = XMLInputFactory.newInstance();
                xmlr = xmlif.createXMLStreamReader("PgAr_Map_5.xml", new FileInputStream("PgAr_Map_5.xml"));
            } catch (Exception e) {
                System.out.println("Errore nell'inizializzazione del reader: ");
                System.out.println(e.getMessage());
            }

            try {
                String tag;
                Citta city = new Citta();
                while (xmlr.hasNext()) {
                    switch (xmlr.getEventType()) {

                        case XMLStreamConstants.END_ELEMENT:
                            //elementoAttuale = "";
                            break;
                        case XMLStreamConstants.START_ELEMENT:

                            tag = xmlr.getLocalName();
                            switch (tag){
                                case "city" : String nomeAttributo;
                                    for(int i=0; i < xmlr.getAttributeCount(); i++){
                                        nomeAttributo = xmlr.getAttributeLocalName(i);
                                        switch (nomeAttributo){
                                            case "id": city.setID(Integer.parseInt(xmlr.getAttributeValue(i)));
                                            break;
                                            case "x" : city.setX(Integer.parseInt(xmlr.getAttributeValue(i)));
                                            break;
                                            case "y": city.setY(Integer.parseInt(xmlr.getAttributeValue(i)));
                                            break;
                                            case "name": city.setNome(String.valueOf(xmlr.getAttributeValue(i)));
                                            break;
                                            case "h": city.setH(Integer.parseInt(xmlr.getAttributeValue(i)));
                                        }
                            if(elementoAttuale.equals("persona")) {
                                if(persona != null) listaPersone.add(persona);
                                    persona = new Persona();
                              }
                            }

                            break;
                        case XMLStreamConstants.CHARACTERS: {
                            if (elementoAttuale.equalsIgnoreCase("cognome")) {
                                String cognome = xmlr.getText();
                                persona.setCOGNOME(cognome);
                            }
                            if (elementoAttuale.equalsIgnoreCase("nome")) {
                                String nome = xmlr.getText();
                                persona.setNOME(nome);
                            }
                            if (elementoAttuale.equalsIgnoreCase("data_nascita")) {
                                String anno = xmlr.getText().substring(0, 4);
                                persona.setANNO(anno);
                                String mese = xmlr.getText().substring(5, 7);
                                persona.setMESE(mese);
                                String giorno = xmlr.getText().substring(8, 10);
                                persona.setGIORNO(giorno);
                            }
                            if (elementoAttuale.equalsIgnoreCase("sesso")) {
                                String sesso = xmlr.getText();
                                persona.setSESSO(sesso);
                            }
                            if (elementoAttuale.equalsIgnoreCase("comune_nascita")) {
                                String comune = xmlr.getText();
                                String codice = estraggoCodiceComune(comune);
                                persona.setCOMUNE(codice);
                            }
                            break;
                        }
                    }
                    xmlr.next();
                }
                xmlr.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return listaPersone;
        }
    }
}
