package entity;

import jakarta.persistence.*;

@Entity
public class Flights {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "flight_number", nullable = false)
    private int flightNumber;
    @Basic
    @Column(name = "airline", nullable = true, length = 255)
    private String airline;
    @Basic
    @Column(name = "source", nullable = false, length = 255)
    private String source;
    @Basic
    @Column(name = "destination", nullable = false, length = 255)
    private String destination;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private int price;
    @Basic
    @Column(name = "customer_id", nullable = false)
    private int customerId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customerByCustomerId;

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flights flights = (Flights) o;

        if (flightNumber != flights.flightNumber) return false;
        if (price != flights.price) return false;
        if (customerId != flights.customerId) return false;
        if (airline != null ? !airline.equals(flights.airline) : flights.airline != null) return false;
        if (source != null ? !source.equals(flights.source) : flights.source != null) return false;
        if (destination != null ? !destination.equals(flights.destination) : flights.destination != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = flightNumber;
        result = 31 * result + (airline != null ? airline.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + customerId;
        return result;
    }

    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }
}
