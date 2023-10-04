#include <iostream>
#include <string>

class Person {
public:
    // Constructor to initialize the attributes
    Person(std::string name, int age) 
    {
        this->name = name;
        this->age = age;
    }

    //Greet age
    void greet() {
        std::cout << "Hello, my name is " << name << " and I am " << age << " years old." << std::endl;
    }

    //Update age
    void updateAge(int newAge) {
        age = newAge;
    }

private:
    std::string name;
    int age;
};

int main() 
{
    // Create an instance of the Person class
    Person person("Adrian", 19);

    // Call the greet method
    person.greet();

    // Update the age
    person.updateAge(20);

    // Call the greet method again
    person.greet();

    return 0;
}
