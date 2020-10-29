package Game;

/**
 * Field
 * @author Gruppe11
 */
public class Field {

    private String fieldMSG;
    private int fieldValue;
    private int fieldNumber;
    private boolean rollAgain;

    /**
     * Dette switch loop definerer hvilket felt spilleren lander på og derfor hvad fieldValue skal være og hvad systemet skal printe.
     * @param fieldNumber
     */
    public void setField(int fieldNumber) {
        fieldValue=0;
        setRollAgain(false);
        switch (fieldNumber) {
            case 2:
                fieldMSG = " har fundet tårnet, det sælger du for 250";
                fieldValue = 250;
                break;

            case 3:
                fieldMSG = " er faldet ned i et krater. Du betaler en mand 100 for at komme op";
                fieldValue = -100;
                break;

            case 4:
                fieldMSG = " står foran paladsets porte. Du får 100 for din fund";
                fieldValue = 100;
                break;

            case 5:
                fieldMSG = " befinder dig i en kold ørken. Du køber en poncho for 20";
                fieldValue = -20;
                break;

            case 6:
                fieldMSG = " finder en by med murer rundt om. Du får 180 for at sælge nogle mursten";
                fieldValue = 180;
                break;

            case 7:
                fieldMSG = " finder et kloster, da de er munke har de ingen penge, og du må gå videre";
                break;

            case 8:
                fieldMSG = " finder en mørk, sort hule, du betaler 70 for en fakkel";
                fieldValue = -70;
                break;

            case 9:
                fieldMSG = " finder en hytte i bjergene. Du får 60 for at finde det.";
                fieldValue = 60;
                break;

            case 10:
                fieldMSG = " finder en mur lavet af døde varulve. Du løber og taber derfor 80\n Du får en ekstra tur!";
                fieldValue = -80;
                setRollAgain(true);
                break;

            case 11:
                fieldMSG = " finder en grube, hvor du taber 50";
                fieldValue = -50;
                break;

            case 12:
                fieldMSG = " finder en guldmine, og blive belønet med 650 guldmønter";
                fieldValue = 650;
                break;
        }
    }

    public int getFieldValue() { return fieldValue; }
    public int getFieldNumber() { return fieldNumber; }
    public void setFieldNumber(int fieldNumber) { this.fieldNumber = fieldNumber; setField(fieldNumber); }
    public String getFieldMSG() { return fieldMSG; }
    public boolean getRollAgain() { return rollAgain; }
    public void setRollAgain(boolean rollAgain) {
        this.rollAgain = rollAgain;
    }
}
