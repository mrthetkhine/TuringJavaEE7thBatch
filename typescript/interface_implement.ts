interface Pingable {
  ping(): void;
}
 
class Sonar implements Pingable {
  ping() {
    console.log("ping!");
  }
}
let sonar:Pingable = new Sonar();
sonar.ping();