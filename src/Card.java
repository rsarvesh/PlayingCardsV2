abstract class Card {
    public final static int NUMBER_OF_SUITS = 4;
    public final static int CARDS_PER_SUIT = 13;
    private final static String[] SUITS ={"Club","Diamond","Heart","Spade"};
    final String PIPS = "23456789TJQKA";

    int seq;
    int rank;
    char pip;
    String suit;

    public char getPip() {
        return pip;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    Card(int seq)
    {
        this.seq = seq;
        this.rank = seq % 13;
        this.pip = PIPS.charAt(this.rank);
        this.suit = SUITS[seq / 13];
    }

    public boolean isNextCard(Card c)
    {
        //return (c.seq - this.seq == 1);
        return ((c.suit.equals(this.suit)) && (c.seq - this.seq == 1));
    }
    public boolean isTen()
    {
        return pip == 'T';
    }
    @Override
    public static int compareTo(Card c1, Card c2)
    {
        return c1.seq - c2.seq;
    }
    public boolean isSameRank(Card c)
    {
        return c.rank == this.rank;
    }
    public boolean isSameSuit(Card c)
    {
        return c.suit.equals(this.suit);
    }
}

class CardNoJoker extends Card{
    CardNoJoker(int seq)
    {
        super(seq);
    }
}
class CardWithJoker extends Card{
    private final static String[] SUITS ={"Club","Diamond","Heart","Spade","Joker"};
    final String PIPS = "23456789TJQKA*"; // * = 13
    public final int JOKER_SEQUENCE = 52;

    CardWithJoker(int seq)
    {
        super(seq);
        if(seq == JOKER_SEQUENCE)
        {
            rank = 13;
            pip = PIPS.charAt(rank);
            suit = SUITS[4];
        }
    }
}
