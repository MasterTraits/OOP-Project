package project;

public class Employee {
  private String name, sex, birthday, address;
  private int age;
  public String cnumber, email;

  // WORK DATA
  private String occupation, dateOfHire, benefits;
  public String department, supervisor;

  // EMERGENCY CONTACT
  private String emergencyContactName, emergencyContactNumber, relationship, emergencyAddress;

  public Employee(String name, String sex, String birthday, int age, String address, String cnumber, String email,
      String occupation, String department, String dateOfHire, String supervisor, String benefits,
      String emergencyContactName, String emergencyContactNumber, String relationship, String emergencyAddress) {

    this.name = name;
    this.sex = sex;
    this.birthday = birthday;
    this.age = age;
    this.address = address;
    this.cnumber = cnumber;
    this.email = email;

    this.occupation = occupation;
    this.department = department;
    this.dateOfHire = dateOfHire;
    this.supervisor = supervisor;
    this.benefits = benefits;

    this.emergencyContactName = emergencyContactName;
    this.emergencyContactNumber = emergencyContactNumber;
    this.relationship = relationship;
    this.emergencyAddress = emergencyAddress;
  }

  public String getName() {
    return name;
  }

  public String getSex() {
    return sex;
  }

  public String getBirthday() {
    return birthday;
  }

  public int getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }

  public String getCnumber() {
    return cnumber;
  }

  public String getEmail() {
    return email;
  }

  public String getOccupation() {
    return occupation;
  }

  public String getDepartment() {
    return department;
  }

  public String getDateOfHire() {
    return dateOfHire;
  }

  public String getSupervisor() {
    return supervisor;
  }

  public String getBenefits() {
    return benefits;
  }

  public String getEmergencyContactName() {
    return emergencyContactName;
  }

  public String getEmergencyContactNumber() {
    return emergencyContactNumber;
  }

  public String getRelationship() {
    return relationship;
  }

  public String getEmergencyAddress() {
    return emergencyAddress;
  }

  @Override
  public String toString() {
    return name + ", " + sex + ", " + birthday + ", " + age + ", " + address + ", " + cnumber + ", " + email +
        ", " + occupation + ", " + department + ", " + dateOfHire + ", " + supervisor + ", " + benefits +
        ", " + emergencyContactName + ", " + emergencyContactNumber + ", " + relationship + ", " + emergencyAddress;
  }

  // public 

}
