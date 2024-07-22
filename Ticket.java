import java.util.Random;

public class Ticket
{
    private String id;
    private String concertHall;
    private int eventCode;
    private long creationTime;
    private boolean isPromo;
    private char stadiumSector;
    private float maxWeight;
    private double price;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();

    public Ticket() {
        this.id = generateID();
        this.creationTime = System.currentTimeMillis()/1000L;
    }

    public Ticket(String concertHall, int eventCode, long creationTime){
        this.id = generateID();
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.creationTime = creationTime;
    }

    public Ticket(String concertHall, int eventCode, long creationTime, boolean isPromo,
                  char stadiumSector, float maxWeight, double price){
        this.id = generateID();
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.creationTime = creationTime;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxWeight = maxWeight;
        this.price = price;
    }

    public void ticketValidation(){
        if (concertHall.length() > 10) {
            throw new IllegalArgumentException("Concerthall cannot be longer than 10 characters.");
        }
        if ((eventCode>999)||(eventCode<0)) {
            throw new IllegalArgumentException("Eventcode must be positive and consist of 3 integers.");
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
        return "Ticket ID is:'" + id +
                ", concert hall is: " + concertHall +
                ", eventcode is: " + eventCode +
                ", ticket creation time is: " + creationTime +
                ", ticket promo is: " + isPromo +
                ", stadium sector is: " + stadiumSector +
                ", max allowed backpack weight (kg.g): " + maxWeight +
                ", price=" + price;
    }
}