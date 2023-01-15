package OOPHW05;

class Contact {
    private String firsName;
    private String lastName;
    private String phoneNumber;
    private String description;
    private String status;

    // Описываю конструтор
    public Contact(ContactBuilder contactBuilder){
        // Для меня обязательны два поля - это firstName и phoneNumber
        // поэтому в конструкторе будет проверка на инициалицаю этих
        // полей.
        if(contactBuilder == null){
            throw new IllegalArgumentException("Пожалуйста воспользуйтесь конструктором ContactBuilder для создания объекта конструктора");
        }
        if(contactBuilder.firstName == null || contactBuilder.firstName.isEmpty()){
            throw new IllegalArgumentException("Пожалуйста введите коректное имя контакта");
        }
        if(contactBuilder.phoneNumber == null || contactBuilder.phoneNumber.isEmpty()){
            throw new IllegalArgumentException("Пожалуйста введите корректный номер телефона");
        }
        this.firsName = contactBuilder.firstName;
        this.lastName = contactBuilder.lastName;
        this.phoneNumber = contactBuilder.phoneNumber;
        this.description = contactBuilder.description;
        this.status = contactBuilder.status;
    }

    public String getFirstName(){
        return firsName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPhonenumber(){
        return phoneNumber;
    }

    public String getDescription(){
        return description;
    }

    public String getStatus(){
        return status;
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Contact [firstName=").append(firsName).append(", lastName=").append(lastName).append(", phoneNumber")
        .append(phoneNumber).append(", description").append(description).append(", status=").append(status)
        .append("]");
        return builder.toString();
    }

    public static class ContactBuilder{
        protected String firstName;
        protected String lastName;
        protected String phoneNumber;
        protected String description;
        protected String status;

        public ContactBuilder(){
            super();

        }

        public ContactBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public ContactBuilder lastNmae(String lastName){
            this.lastName = lastName;
            return this;
        }

        public ContactBuilder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public ContactBuilder description(String description){
            this.description = description;
            return this;
        }

        public ContactBuilder status(String status){
            this.status = status;
            return this;
        }

        public Contact build(){
            Contact contact = null;
            contact = new Contact(this);
            return contact;

        }
    }

}

public class ContactMain{
    public static void main(String[] args) {
        Contact contact1 = new Contact.ContactBuilder().firstName("Arman").phoneNumber("7777777").build();
        System.out.println(contact1);
    }
}
