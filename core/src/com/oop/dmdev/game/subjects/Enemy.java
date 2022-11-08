package com.oop.dmdev.game.subjects;

public abstract class Enemy implements Mortal, Attacking
{
    private final String name;
    private int health;
    private final int damage;

    public Enemy(String name, int health, int damage)
    {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    @Override
    public void takeDamage(int damage)
    {
        if (isAlive() && (health <= damage)) {
            health = 0;
            System.out.printf("%s получил урон %d. Враг повержен.\n",
                name, damage);
        } else {
            health -= Math.min(health, damage);
            System.out.printf("%s получил урон %d. Осталось %d\n",
                name, damage, health);
        }
    }

    @Override
    public boolean isAlive()
    {
        return (health > 0);
    }

    @Override
    public String getName()
    {
        return name;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getDamage()
    {
        return damage;
    }
}
