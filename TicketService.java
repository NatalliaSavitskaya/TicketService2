class TicketService
{
    public static void main(String []args)
    {
        Ticket emptyTicket = new Ticket();
        System.out.println("The info about the empty ticket is:" + emptyTicket.toString());

        Ticket limitedTicket = new Ticket("Alexandria", "012", System.currentTimeMillis()/1000L);
        System.out.println("The info about the limited ticket is: " + limitedTicket.toString());

        Ticket fullTicket = new Ticket("Alexandria", "012", System.currentTimeMillis()/1000L, true, 'A', 100, 12);
        fullTicket.ticketValidation();
        System.out.println("The info about the full ticket is: " + fullTicket.toString());
    }
};
