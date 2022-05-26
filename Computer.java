//Computer Class
package za.ac.wsu.s217120407;

import java.text.DecimalFormat;

/**
 *
 * @author Zonke Mavana 217120407
 */
public class Computer {

    private String sIPAddress;
    private float fValueAmount;

    /**
     * 
     * @param sIPAddress
     * @param fValueAmount 
     */
    public Computer(String sIPAddress, float fValueAmount) {
        this.sIPAddress = sIPAddress;
        this.fValueAmount = fValueAmount;

    }

    /**
     * @return the IP Address
     */
    public String getsIPAddress() {
        return sIPAddress;
    }

    /**
     *
     * @return Value Amount
     */
    public float getfValueAmount() {
        return fValueAmount;
    }

    /**
     * @param sIPAddress the name to set
     */
    public void setsIPAddress(String sIPAddress) {
        this.sIPAddress = sIPAddress;
    }

    /**
     * 
     * @param fValueAmount
     * @throws MyException 
     */
    public void setiValueAmount(float fValueAmount) throws MyException {
        
            this.fValueAmount = fValueAmount;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("$#,##0.00");
        return sIPAddress + " " +decimalFormat.format(fValueAmount )+ "\n";
    }
}
