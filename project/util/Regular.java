package project.util;

// Class for Full-Time Regulars
class Regular extends Employee {
  private int courseLoad;
  private boolean isTenured;
  private double researchBonus;

  public Regular(String firstName, String lastName, int id, double baseSalary, int courseLoad, boolean isTenured, double researchBonus, String occupation, String department) {
      
      super(firstName, lastName, id, baseSalary, occupation, department);
      this.courseLoad = courseLoad;
      this.isTenured = isTenured;
      this.researchBonus = researchBonus;
  }

  @Override
  public double calculateSalary() {
      return getBaseSalary() + (courseLoad * 500) + (isTenured ? 1000 : 0) + researchBonus;
  }

  @Override
  public String toString() {
      return super.toString() + String.format("\nCourses: %d\t\tTenured: %b\nResearch Bonus: ₱%.2f", courseLoad, isTenured, researchBonus);
  }

  public double getBaseSalary() {
      return super.calculateSalary();
  }

  public void setCourseLoad(int courseLoad) {
      this.courseLoad = courseLoad;
  }

  public void setTenured(boolean tenured) {
      isTenured = tenured;
  }

  public void setResearchBonus(double researchBonus) {
      this.researchBonus = researchBonus;
  }
}