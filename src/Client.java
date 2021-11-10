package com.kwame;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String firstName, lastName;
    private MembershipType membershipType;
    private int points;

    private List<TradeAb> trades;


    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.points = 0;
        trades = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addTrade(TradeAb trade) {

        if (!canTrade()) {
            return;
        }

        trades.add(trade);

        points++;

        if (points < 10) {
            setMembershipType(new Bronze());
        }else if (points <= 19) {
            setMembershipType(new Silver());
        }else {
            setMembershipType(new Gold());
        }
    }

    public boolean canTrade() {
        if (membershipType == null) return true;

        String type = membershipType.getType();

        double total = trades.stream().map(TradeAb::price).reduce(0.0, Double::sum);

        if (total > 10000) {
            return false;
        }

       if (type.equalsIgnoreCase("bronze") && trades.size() == 5) {
           return false;
       }else if (type.equalsIgnoreCase("silver") && trades.size() == 10) {
           return false;
       }else if (type.equalsIgnoreCase("gold") && trades.size() == 20) {
           return false;
       }

       return true;
    }
}
