package encapsulation.exercise.pizzaCalorie;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (flourType.equalsIgnoreCase("white") ||
                flourType.equalsIgnoreCase("wholegrain")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equalsIgnoreCase("crispy") ||
        bakingTechnique.equalsIgnoreCase("chewy") ||
        bakingTechnique.equalsIgnoreCase("homemade")){
            this.bakingTechnique = bakingTechnique;
        } else{
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight){
        if(weight >= 1 && weight <= 200){
            this.weight = weight;
        } else{
            throw new IllegalArgumentException("encapsulation.exercise.pizzaCalorie.Dough weight should be in the range [1..200].");
        }
    }

    private String getFlourType(){
        return this.flourType;
    }

    private String getBakingTechnique(){
        return this.bakingTechnique;
    }

    public double calculateCalories(){
        double baseCalorie = this.weight * 2;
        double modifierFlour = DoughModifiers.valueOf(this.getFlourType()).getModifier();
        double modifierTechnique = DoughModifiers.valueOf(this.getBakingTechnique()).getModifier();
        return baseCalorie * modifierFlour * modifierTechnique;
    }
}
