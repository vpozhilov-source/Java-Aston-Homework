public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Мурзик");
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");
        
        cat1.run(150);
        cat1.run(250);
        dog1.run(400);
        dog1.run(600);
        
        cat1.swim(5);
        dog1.swim(8);
        dog1.swim(15);
        
        Bowl bowl = new Bowl(25);
        Cat[] cats = {cat1, cat2, new Cat("Рыжик")};
        
        for (Cat cat : cats) {
            cat.eat(bowl, 10);
        }
        
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + cat.isFull());
        }
        
        bowl.addFood(20);
        
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(bowl, 10);
            }
        }
        
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Котов: " + Cat.getCatCount());
        System.out.println("Собак: " + Dog.getDogCount());
    }
}
