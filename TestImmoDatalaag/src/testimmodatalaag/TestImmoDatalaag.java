/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testimmodatalaag;

import be.ugent.tiwi.immo.interfaces.IBod;
import be.ugent.tiwi.immo.interfaces.IFoto;
import be.ugent.tiwi.immo.interfaces.IGemeente;
import be.ugent.tiwi.immo.interfaces.IPand;
import be.ugent.tiwi.immo.interfaces.IPersoon;
import be.ugent.tiwi.immo.interfaces.IType;
import be.ugent.tiwi.immo.jdbc.implementatie.ImmoDataStorage;

import java.util.List;

/**
 *
 * @author kvdw, aangepast vongenae
 */
public class TestImmoDatalaag {

    public static void main(String[] args) {
        try {

            // aanmaken en instellen datalaag
            ImmoDataStorage immo = new ImmoDataStorage();
            immo.setDriver("com.mysql.jdbc.Driver");
            immo.setConnectieString("jdbc:mysql://localhost:3306/immo");
            immo.setUsername("root");
            immo.setWachtwoord("root");
            
            // informatie opvragen
            List<IGemeente> gemeentes = immo.getGemeentes();

            System.out.println("Lijst van gemeentes.");
            for (IGemeente gemeente : gemeentes) {
                System.out.println(gemeente.getId() + " " + gemeente.getNaam() + " " + gemeente.getPostcode());
            }

            System.out.println("\nLijst van verwarmingsTypes");
            List<IType> verwarmingsTypes = immo.getVerwarmingsTypes();

            for (IType type : verwarmingsTypes) {
                System.out.println(type.getId() + " " + type.getNaam());
            }

            System.out.println("\nLijst van gebouwTypes");
            List<IType> gebouwTypes = immo.getGebouwTypes();

            for (IType type : gebouwTypes) {
                System.out.println(type.getId() + " " + type.getNaam());
            }

            System.out.println("Eén enkel verwarmingsType ophalen.");
            IType verwarmingsType = immo.getVerwarmingsType(1);

            System.out.println(verwarmingsType.getId() + " " + verwarmingsType.getNaam());

            System.out.println("Eén enkele gemeente ophalen.");
            IGemeente gemeente = immo.getGemeente(1);

            System.out.println(gemeente.getId() + " " + gemeente.getNaam() + " " + gemeente.getPostcode());

            System.out.println("Eén enkel gebouwType ophalen.");
            IType gebouwType = immo.getGebouwType(4);

            System.out.println(gebouwType.getId() + " " + gebouwType.getNaam());

            System.out.println("Persoon opvragen via login en wachtwoord");
            IPersoon persoon = immo.getCredentials("JJ", "wachtwoord");

            System.out.println(persoon.getId() + " " + persoon.getLogin() + " " + persoon.getEmail() + " " + persoon.getNaam() + " " + persoon.getGeboorteDatum());

            System.out.println("Lijst van panden");
            List<IPand> panden = immo.getPanden(3, 0, 2000000);

            for (IPand pand : panden) {
                System.out.println(pand.getId() + " " + pand.getAantalSlaapkamers() + " " + pand.getStraat() + " " + pand.getNummer());
                System.out.println(pand.getGemeente().getId() + " " + pand.getGemeente().getNaam() + " " + pand.getGemeente().getPostcode());
                System.out.println(pand.getHeeftTuin() + " " + pand.getHeeftTerras() + " " + pand.getAantalBadkamers() + " " + pand.getBewoonbareRuimte() + " " + pand.getVraagPrijs());
                System.out.println(pand.getStatus() + " " + pand.getVerwarmingsType().getNaam() + " " + pand.getGebouwType().getNaam() + " " + pand.getVerkoper().getNaam());
                for (IBod bod : pand.getLijstBiedingen()) {
                    System.out.println(bod.getPersoonId() + " " + bod.getPandId() + " " + bod.getPrijs() + " " + bod.getDatum());
                }
                for (IFoto foto : pand.getLijstFotos()) {
                    System.out.println(foto.getLink());
                }
            }

            System.out.println("Ophalen van pand aan de hand van id");
            IPand pand = immo.getPand(2);
            System.out.println(pand.getId() + " " + pand.getAantalSlaapkamers() + " " + pand.getStraat() + " " + pand.getNummer());
            System.out.println(pand.getGemeente().getId() + " " + pand.getGemeente().getNaam() + " " + pand.getGemeente().getPostcode());
            System.out.println(pand.getHeeftTuin() + " " + pand.getHeeftTerras() + " " + pand.getAantalBadkamers() + " " + pand.getBewoonbareRuimte() + " " + pand.getVraagPrijs());
            System.out.println(pand.getStatus() + " " + pand.getVerwarmingsType().getNaam() + " " + pand.getGebouwType().getNaam() + " " + pand.getVerkoper().getNaam());
            for (IBod bod : pand.getLijstBiedingen()) {
                System.out.println(bod.getPersoonId() + " " + bod.getPandId() + " " + bod.getPrijs() + " " + bod.getDatum());
            }
            for (IFoto foto : pand.getLijstFotos()) {
                System.out.println(foto.getLink());
            }

            System.out.println("Ophalen van de panden van een persoon");
            panden = immo.getPandenPersoon(2);

            for (IPand p : panden) {
                System.out.println(pand.getId() + " " + pand.getAantalSlaapkamers() + " " + pand.getStraat() + " " + pand.getNummer());
                System.out.println(pand.getGemeente().getId() + " " + pand.getGemeente().getNaam() + " " + pand.getGemeente().getPostcode());
                System.out.println(pand.getHeeftTuin() + " " + pand.getHeeftTerras() + " " + pand.getAantalBadkamers() + " " + pand.getBewoonbareRuimte() + " " + pand.getVraagPrijs());
                System.out.println(pand.getStatus() + " " + pand.getVerwarmingsType().getNaam() + " " + pand.getGebouwType().getNaam() + " " + pand.getVerkoper().getNaam());
                for (IBod bod : pand.getLijstBiedingen()) {
                    System.out.println(bod.getPersoonId() + " " + bod.getPandId() + " " + bod.getPrijs() + " " + bod.getDatum());
                }
                for (IFoto foto : pand.getLijstFotos()) {
                    System.out.println(foto.getLink());
                }
            }

            System.out.println("Pand toevoegen");
            IPand p = immo.createNewPand();
            p.setAantalSlaapkamers(5);
            p.setHeeftTuin(true);
            p.setStraat("vioolstraat");
            p.setNummer(3);
            p.setGemeente(immo.getGemeente(2));
            p.setHeeftTerras(true);
            p.setAantalBadkamers(2);
            p.setBewoonbareRuimte(300.54);
            p.setVraagPrijs(10000.87);
            p.setVerwarmingsType(immo.getVerwarmingsType(2));
            p.setGebouwType(immo.getGebouwType(4));
            p.setVerkoper(immo.getCredentials("JJ", "wachtwoord"));
            IFoto f1 = immo.createNewFoto();
            f1.setLink("picture1.jpg");
            p.addFoto(f1);
            f1 = immo.createNewFoto();
            f1.setLink("picture2.jpg");
            p.addFoto(f1);

            immo.voegPandToe(p);

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }


    }
}