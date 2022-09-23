public class MainElement {
    private int hp = 10;
    private int max_damage;
    private boolean is_defeted = false;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMax_damage() {
        return max_damage;
    }

    public void setMax_damage(int max_damage) {
        this.max_damage = max_damage;
    }

    public boolean isIs_defeted() {
        return is_defeted;
    }

    public void setIs_defeted(boolean is_defeted) {
        this.is_defeted = is_defeted;
    }

    public MainElement(int max_damage) {
        this.max_damage = max_damage;
    }

    public void recive_damage(int damage) {
        this.hp -= damage;
        if (hp < 0)
            hp = 0;
        is_defeted = (hp == 0);
    }

}
