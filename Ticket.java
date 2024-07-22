import java.util.Random;

public class Ticket
{
    private String idTicket;
    private String concertHall;
    private int eventCode;
    private long unixTimeStamp;
    private boolean isPromo;
    private char stadiumSector;
    private float maxWeight;
    private double price;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();

    public Ticket() {
        this.idTicket = generateID();
        this.unixTimeStamp = System.currentTimeMillis()/1000L;
    }

    public Ticket(String concertHall, int eventCode, long unixTimeStamp){
        this.idTicket = generateID();
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.unixTimeStamp = unixTimeStamp;
    }

    public Ticket(String concertHall, int eventCode, long unixTimeStamp, boolean isPromo,
                  char stadiumSector, float maxWeight, double price){
        this.idTicket = generateID();
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.unixTimeStamp = unixTimeStamp;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxWeight = maxWeight;
        this.price = price;
    }

    public void ticketValidation(){
        if (concertHall.length() > 10) {
            throw new IllegalArgumentException("Concerthall cannot be longer than 10 characters.");
        }
        if ( (int) Math.floor(Math.log10(Math.abs(eventCode))) != 2) {
            throw new IllegalArgumentException("Eventcode must consist of 3 integers.");
        }
    }

    private String generateID(){
        StringBuilder id = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            id.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return id.toString();
    }

    public String toString() {
        return "Ticket ID is:'" + idTicket +
                ", concert hall is: " + concertHall +
                ", eventcode is: " + eventCode +
                ", ticket creation time is: " + unixTimeStamp +
                ", ticket promo is: " + isPromo +
                ", stadium sector is: " + stadiumSector +
                ", max allowed backpack weight (kg.g): " + maxWeight +
                ", price=" + price;
    }
}