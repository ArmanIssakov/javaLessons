package OOPHW05;
// Описание класса (компоненты) Contact
// используя паттерн Builder
class Contact {
    private String firstName;
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
        this.firstName = contactBuilder.firstName;
        this.lastName = contactBuilder.lastName;
        this.phoneNumber = contactBuilder.phoneNumber;
        this.description = contactBuilder.description;
        this.status = contactBuilder.status;
    }
    //Описываем геттеры
    public String getFirstName(){
        return firstName;
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
        builder.append("").append(firstName).append(",").append(lastName).append(",")
        .append(phoneNumber).append(",").append(description).append(",").append(status);
        
        return builder.toString();
    }
    //Описываю вложенный класс ContactBuilder
    public static class ContactBuilder{
        protected String firstName;
        protected String lastName;
        protected String phoneNumber;
        protected String description;
        protected String status;
            // НУЖНО ЛИ ОПИСЫВАТЬ КОНСТРУКТОР ДЛЯ ВЛОЖЕННОГО КЛАССА?
            // ЕСЛИ ДА ТО КАК ЭТО ПРОИСХОДИТ?
        // public ContactBuilder(){
        //     super();

        // }
            //МОЖНО ЛИ СКАЗАТЬ, ЧТО ВО ВСЕХ ЭТИХ МЕТОДАХ Я ПОСТОЯННО СОЗДАЮ ОБЪЕКТНУЮ ПЕРЕМЕННУЮ CONTAСTBUILDER?
        public ContactBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public ContactBuilder lastName(String lastName){
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
            Contact contact;
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
