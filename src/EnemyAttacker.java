import java.sql.SQLOutput;
import java.util.Random;

public interface EnemyAttacker {
    public void FireWeapon();
    public void DriveForward();
    public void AssignDriver(String Driver);
}
class EnemyTank implements EnemyAttacker{
Random generator=new Random();
    @Override
    public void FireWeapon() {
        int attackDamage=generator.nextInt(10)+1;
        System.out.println("Enemy Tank does "+attackDamage+" damage");
    }

    @Override
    public void DriveForward() {
int movement=generator.nextInt(5)+1;
        System.out.println("Enemey Tank moves "+movement+" spaces");
    }

    @Override
    public void AssignDriver(String Driver) {
        System.out.println(Driver+" is driving the tank");
    }
}
class EnemyRobot{
    Random generator=new Random();
    public void smashWithHand(){
        int attackDamage=generator.nextInt(10)+1;
        System.out.println("Enemy Robot causes "+attackDamage+" damage with hands");
    }
    public void WalkForward(){
        int movement=generator.nextInt(5)+1;
        System.out.println("Enemy Robot moves "+movement+" spaces");
    }
    public void reactToHumans(String drivername){

    }
}
class EnemyRobotAdapter implements EnemyAttacker{
EnemyRobot enemyRobot;

    public EnemyRobotAdapter(EnemyRobot enemyRobot) {
        this.enemyRobot = enemyRobot;
    }

    @Override
    public void FireWeapon() {
        enemyRobot.smashWithHand();
    }

    @Override
    public void DriveForward() {

    }

    @Override
    public void AssignDriver(String Driver) {

    }
}
class TestEveryAttacker{
    public static void main(String[] args) {
        EnemyTank rx7Tank=new EnemyTank();
        EnemyRobot terminator=new EnemyRobot();
        EnemyRobotAdapter robotAdapter=new EnemyRobotAdapter(terminator);
        System.out.println("THE ROBOT");
        terminator.reactToHumans("Wesley");
        terminator.WalkForward();
        terminator.smashWithHand();
        System.out.println("THE ENEMY TANK");
        rx7Tank.AssignDriver("Frank");
        rx7Tank.DriveForward();
        rx7Tank.FireWeapon();
        System.out.println("THE ROBOT WITH THE ATTACKER");
        robotAdapter.AssignDriver("Mark");
        robotAdapter.DriveForward();
        robotAdapter.FireWeapon();
    }
}
