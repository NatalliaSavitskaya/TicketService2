import java.util.Random;
import java.time.LocalDateTime;

public class Ticket
{
    private String id;
    private String concertHall;
    private String eventCode;
    private long eventTime;
    private boolean isPromo;
    private char stadiumSector;
    private double maxWeight;
    private LocalDateTime creationTime;
    private double price;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();

    public Ticket() {
        this.id = generateID();
        this.creationTime = LocalDateTime.now();
    }

    public Ticket(String concertHall, String eventCode, long eventTime){
        this.id = generateID();
        this.creationTime = LocalDateTime.now();
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.eventTime = eventTime;
    }

    public Ticket(String concertHall, String eventCode, long eventTime, boolean isPromo,
                  char stadiumSector, double maxWeight, double price){
        this.id = generateID();
        this.creationTime = LocalDateTime.now();
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.eventTime = eventTime;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxWeight = maxWeight;
        this.price = price;
    }

    public void ticketValidation() {
        if (concertHall.length() > 10) {
            throw new IllegalArgumentException("Concerthall cannot be longer than 10 characters.");
        }
        if (!eventCode.matches("\\d{3}")) {
            throw new IllegalArgumentException("Eventcode must consist of 3 digits.");
        }
        if (eventTime<System.currentTimeMillis()/1000L) {
            throw new IllegalArgumentException("Event time is in the past.");
        }
        if ((stadiumSector<'A')||(stadiumSector>'C')) {
            throw new IllegalArgumentException("Stadium sector should be A, B or C.");
        }
        if (maxWeight<0) {
            throw new IllegalArgumentException("Max weight can't be negative.");
        }
        if (price<0) {
            throw new IllegalArgumentException("Price can't be negative.");
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
                ", ticket creation time is: " + creationTime +
                ", concert hall is: " + concertHall +
                ", event code is: " + eventCode +
                ", event time is: " + eventTime +
                ", ticket is promo: " + isPromo +
                ", stadium sector is: " + stadiumSector +
                ", max allowed backpack weight (kg.g): " + String.format("%.2f", maxWeight) +
                ", price=" + String.format("%.2f", price);
    }
}