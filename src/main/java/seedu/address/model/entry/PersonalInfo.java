package seedu.address.model.entry;

public class PersonalInfo {
    private Name name;
    private Address address;
    private Phone phone;
    private Email email;
    private String github;

    public PersonalInfo(Name name, Address address, Phone phone, Email email, String github) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.github = github;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public String getGithub() {
        return github;
    }
}
