public class Ticket
{
    private String idTicket;
    private String concertHall;
    private int eventCode;
    private long unixTimeStamp;
    private boolean isPromo;
    private char stadiumSector;
    private float maxWeight;

    public Ticket() {
    }

    public Ticket(String concertHall, int eventCode, long unixTimeStamp){
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.unixTimeStamp = unixTimeStamp;
    }

    public Ticket(String idTicket, String concertHall, int eventCode, long unixTimeStamp, boolean isPromo, char stadiumSector, float maxWeight){
        if (idTicket.length() > 4) {
            throw new IllegalArgumentException("ID cannot be longer than 4 characters.");
        }
        this.idTicket = idTicket;
        if (concertHall.length() > 10) {
            throw new IllegalArgumentException("Concerthall cannot be longer than 10 characters.");
        }
        this.concertHall = concertHall;
        if ( (int) Math.floor(Math.log10(Math.abs(eventCode))) != 2) {
            throw new IllegalArgumentException("Eventcode must consist of 3 integers.");
        }
        this.eventCode = eventCode;
        this.unixTimeStamp = unixTimeStamp;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxWeight = maxWeight;
    }

    public void printTicket(){
        System.out.println("Ticket ID: " + idTicket);
        System.out.println("The concert hall is: " + concertHall);
        System.out.println("The event code is: " + eventCode);
        System.out.println("The ticket creation time is: " + unixTimeStamp);
        System.out.println("This is a promo ticket: " + isPromo);
        System.out.println("The stadium sector is: " + stadiumSector);
        System.out.println("Max allowed backpack weight (kg.g): " + maxWeight);
    }
}