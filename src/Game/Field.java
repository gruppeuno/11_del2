package Game;

public class Field {

    private String fieldMSG;
    private int fieldValue = 0;
    private int fieldNumber;


    public void setField() {
        fieldValue=0;

        switch (fieldNumber) {
            case 2:
                fieldMSG = "Du har fundet tårnet, det sælger du for 250";
                fieldValue = 250;
                break;

            case 3:
                fieldMSG = "Du er faldet ned i et krater. Du betaler en mand 100 for at komme op";
                fieldValue = -100;
                break;

            case 4:
                fieldMSG = "Du står foran paladsets porte. Du får 100 for din fund";
                fieldValue = 100;
                break;

            case 5:
                fieldMSG = "Du befinder dig i en kold ørken. Du køber en poncho for 20";
                fieldValue = -20;
                break;

            case 6:
                fieldMSG = "Du finder en by med murer rundt om. Du får 180 for at sælge nogle mursten";
                fieldValue = 180;
                break;

            case 7:
                fieldMSG = "Du finder et kloster, da de er munke har de ingen penge, og du må gå videre";
                break;

            case 8:
                fieldMSG = "Du finder en mørk, sort hule, du betaler 70 for en fakkel";
                fieldValue = -70;
                break;

            case 9:
                fieldMSG = "Du finder en hytte i bjergene. Du får 60 for at finde det.";
                fieldValue = 60;
                break;

            case 10:
                fieldMSG = "Du finder en mur lavet af døde varulve. Du løber og taber derfor 80";
                fieldValue = -80;

                break;

            case 11:
                fieldMSG = "Du finder en grube, hvor du taber 50";
                fieldValue = -50;
                break;

            case 12:
                fieldMSG = "Du finder en guldmine, og blive belønet med 650 guldmønter";
                fieldValue = 650;
                break;
        }
    }

    public int getFieldValue() {
        return fieldValue;
    }

    //TODO: slet efter test
    public int getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public String getFieldMSG() {
        return fieldMSG;
    }

}
