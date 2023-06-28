
/*Proyecto Final Desarrollo de Sistema Distribuidos
4CM14 Tavares Rizo, Manuel Alexis
4CM12 Vazquez Perez, Denzel Omar
4CM13 Lopez Gonzalez, Enrique

*/
package frontEnd.auxiliares;

public class Text {
	public String name;
	public double fitness;
	
	public Text(String name, double fitness) {
		this.name = name;
		this.fitness = fitness;
	}
	
	@Override
	public String toString() {
		return name + "," + fitness;
	}
}