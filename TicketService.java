class TicketService
{
    public static void main(String []args)
    {
        Ticket emptyTicket = new Ticket();
        System.out.println("The info about the empty ticket is:" + emptyTicket.toString());

        String concertHall = "Alexandria";
        int eventCode = 111;
        long unixTimeStamp = System.currentTimeMillis()/1000L;
        Ticket limitedTicket = new Ticket(concertHall, eventCode, unixTimeStamp);
        limitedTicket.ticketValidation();
        System.out.println("The info about the limited ticket is: " + limitedTicket.toString());

        Ticket fullTicket = new Ticket(concertHall, eventCode, unixTimeStamp, true, 'A', 55.95F, 12.34);
        fullTicket.ticketValidation();
        System.out.println("The info about the full ticket is: " + fullTicket.toString());
    }
};
