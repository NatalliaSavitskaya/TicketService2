class TicketService
{
    public static void main(String []args)
    {
        Ticket emptyTicket = new Ticket();
        System.out.println("The info about the empty ticket is:");
        emptyTicket.printTicket();

        String concertHall = "ConcertHal";
        int eventCode = 111;
        long unixTimeStamp = System.currentTimeMillis()/1000L;
        Ticket limitedTicket = new Ticket(concertHall, eventCode, unixTimeStamp);
        System.out.println("The info about the limited ticket is:");
        limitedTicket.printTicket();

        String idTicket = "AB12";
        Ticket fullTicket = new Ticket(idTicket, concertHall, eventCode, unixTimeStamp,
                true, 'A', 55.95F);
        System.out.println("The info about the full ticket is:");
        fullTicket.printTicket();
    }
};
