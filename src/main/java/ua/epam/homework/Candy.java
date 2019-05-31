package ua.epam.homework;

public class Candy {
	private String name;
	private String manufacturer;
	private float weight;

	private Integer proteins;
	private Integer fats;
	private Integer carbohydrates;

	private float energyValue;

	private SweetTypes sweetType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Integer getProteins() {
		return proteins;
	}

	public void setProteins(Integer proteins) {
		this.proteins = proteins;
	}

	public Integer getFats() {
		return fats;
	}

	public void setFats(Integer fats) {
		this.fats = fats;
	}

	public Integer getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(Integer carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public float getEnergyValue() {
		return energyValue;
	}

	public void setEnergyValue(float energyValue) {
		this.energyValue = energyValue;
	}

	public SweetTypes getSweetType() {
		return sweetType;
	}

	public void setSweetType(SweetTypes sweetType) {
		this.sweetType = sweetType;
	}
}
