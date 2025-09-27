#include <iostream>
#include <cctype>
#include <string>
#include <fstream>
#include <stdexcept>
#include <sstream>
#include <iomanip>
#include <algorithm>

using namespace std;

//Function Prototypes
void displayProjectInterface();
void getUserChoice();
void addStudRecord();
void displayAllRecords();
void saveRecordToFile();
void loadRecordFromFile();
void searchStudByName();
void delRecordByRollNo();
void updateRecordByMobileNo();
void sortRecordByRollNo();

int getValidRollNo(string prompt);
string getValidName(string prompt);
string getValidGender(string prompt);
int getValidAge(string prompt);
float getValidCgpa(string prompt);
string getValidCity(string prompt);
string getValidMobile(string prompt);
float getValidMarks(string prompt);
float getTotalMarks(float marks1, float marks2, float marks3);
char getGrade(float totalMarks);
bool duplicateRollNo(int rollNo);

//Structure
struct Students
{
    int rollNo;
    string name;
    string gender;
    int age;
    float cgpa;
    float totalMarks;
    char grade;
    string city;
    string mobile;
    float marksSubject1;
    float marksSubject2;
    float marksSubject3;
};

//Global Constants
const int MAX_LENGTH = 100;
const string FILE_PATH = "D:/Student.txt";

//Global Variables
Students student[MAX_LENGTH];
int counter = 0;

int main()
{
    //Functions calling
    displayProjectInterface();
    getUserChoice();
    return 0;
}//End Main

//Function: Display Interface
void displayProjectInterface()
{
    cout << "=====================================================" << endl;
    cout << "    C++ SEMESTER PROJECT - ASSIGNMENT 4" << endl;
    cout << "    Student Record Management System" << endl;
    cout << "=====================================================" << endl << endl;

    cout << "1. Add New Student Record" << endl;
    cout << "2. Display All Student Records" << endl;
    cout << "3. Save Records to File" << endl;
    cout << "4. Load Records from File" << endl;
    cout << "5. Search Student by Name" << endl;
    cout << "6. Delete Record by Roll No" << endl;
    cout << "7. Update Record by Mobile No" << endl;
    cout << "8. Sort Records by Roll No" << endl;
    cout << "0. Exit" << endl;
}

//Function: Getting user's choice
void getUserChoice()
{
    int choice;
    bool validChoice = false;

    do
    {
        try
        {
            cout << "-----------------------------------------------------" << endl;
            cout << "Enter your choice: ";
            cin >> choice;

            // Input validation
            if(cin.fail())
            {
                cin.clear();
                cin.ignore(1000, '\n');
                throw string(" [!]Invalid Input. Must be an integer (0-8)\n\n");
            }

            if(choice > 8 || choice < 0)
                throw string(" [!]Invalid Input. Choice must be between 0 and 8\n\n");
            if(choice==0)
            {
                validChoice = true;
            }


            switch(choice)
            {
                case 1: addStudRecord(); break;
                case 2: displayAllRecords(); break;
                case 3: saveRecordToFile(); break;
                case 4: loadRecordFromFile(); break;
                case 5: searchStudByName(); break;
                case 6: delRecordByRollNo(); break;
                case 7: updateRecordByMobileNo(); break;
                case 8: sortRecordByRollNo(); break;
                case 0: cout << "Exiting... Thank you.\n"; break;
                default: throw string("Invalid Choice. Please enter a number between 0 and 8.\n");
            }
        }
        catch(const string e)
        {
            cout << e;
        }
    } while(!validChoice);
}

//Function: Adding Record of Student
void addStudRecord()
{
    student[counter].rollNo = getValidRollNo("\nEnter Roll No: ");
    student[counter].name = getValidName("Name: ");
    student[counter].gender = getValidGender("Gender: ");
    student[counter].age = getValidAge("Age: ");
    student[counter].cgpa = getValidCgpa("CGPA: ");
    student[counter].city = getValidCity("City: ");
    student[counter].mobile = getValidMobile("Mobile: ");
    student[counter].marksSubject1 = getValidMarks("Marks in Subject 1: ");
    student[counter].marksSubject2 = getValidMarks("Marks in Subject 2: ");
    student[counter].marksSubject3 = getValidMarks("Marks in Subject 3: ");
    student[counter].totalMarks = getTotalMarks(student[counter].marksSubject1, student[counter].marksSubject2, student[counter].marksSubject3);
    student[counter].grade = getGrade(student[counter].totalMarks);

    cout << "\n> Student record added successfully.\n" << endl;

    counter++;
}
//Function: Adding Student Record
void displayAllRecords()
{
    if(counter == 0)
    {
        cout << "[!] Nothing to display. The file contains no student records.\n";
        return;
    }

    cout << "\n--- Student Records ---\n";
    for(int i=0; i<counter; i++)
    {
        cout << "Roll No: " << student[i].rollNo << endl;
        cout << "Name: " << student[i].name << endl;
        cout << "Gender: " << student[i].gender << endl;
        cout << "Age: " << student[i].age << endl;
        cout << "CGPA: " << student[i].cgpa << endl;
        cout << "Total Marks: " << student[i].totalMarks << endl;
        cout << "Grade: " << student[i].grade << endl;
        cout << "City: " << student[i].city << endl;
        cout << "Mobile: " << student[i].mobile << endl << endl;
    }
}

//Function: Save Record to File
void saveRecordToFile()
{
    if(counter == 0)
    {
        cout << "[!] Nothing to save. Please add students before performing this action.\n";
        return;
    }
    try
    {
        ofstream fileToWrite(FILE_PATH);
        if(!fileToWrite.is_open())
        {
            throw string("[!] Required file not found. Please make sure the data file exists.\n");
        }

        fileToWrite << "RollNo\tName\tGender\tAge\tCGPA\tGrade\tCity\tMobile\t\tMarks1\tMarks2\tMarks3\n";
        for(int i=0; i<counter; i++)
        {
            fileToWrite << student[i].rollNo << "\t"
                << student[i].name << "\t"
                << student[i].gender << "\t"
                << student[i].age << "\t"
                << student[i].cgpa << "\t"
                << student[i].grade << "\t"
                << student[i].city << "\t"
                << student[i].mobile << "\t"
                << student[i].marksSubject1 << "\t"
                << student[i].marksSubject2 << "\t"
                << student[i].marksSubject3 << "\n";
        }
        fileToWrite.close();
        system("start D://Student.txt");
        cout << "> Records saved to file successfully.\n\n";

    }catch(const string e)
    {
        cout << e;
    }
}

//Function: Load Record from File;
void loadRecordFromFile()
{
    if(counter == 0)
    {
        cout << "[!] Nothing to load. Please add students before performing this action.\n";
        return;
    }
    try
    {
        ifstream fileToRead(FILE_PATH);
        if(!fileToRead.is_open())
        {
            throw string("[!]Error. File not opened yet.\n");
        }

        string line;
        counter = 0;
        getline(fileToRead, line); //Skipping the header

        while(getline(fileToRead, line) && counter < MAX_LENGTH)
        {
            istringstream iss(line);
            string roll, name, gender, age, cgpa, grade, city, mobile, m1, m2, m3;

            getline(iss, roll, '\t');
            getline(iss, name, '\t');
            getline(iss, gender, '\t');
            getline(iss, age, '\t');
            getline(iss, cgpa, '\t');
            getline(iss, grade, '\t');
            getline(iss, city, '\t');
            getline(iss, mobile, '\t');
            getline(iss, m1, '\t');
            getline(iss, m2, '\t');
            getline(iss, m3, '\t');

            student[counter].rollNo = stoi(roll);
            student[counter].name = name;
            student[counter].gender = gender;
            student[counter].age = stoi(age);
            student[counter].cgpa = stof(cgpa);
            student[counter].grade = grade[0];
            student[counter].city = city;
            student[counter].mobile = mobile;
            student[counter].marksSubject1 = stof(m1);
            student[counter].marksSubject2 = stof(m2);
            student[counter].marksSubject3 = stof(m3);
            student[counter].totalMarks = getTotalMarks(
        student[counter].marksSubject1,
        student[counter].marksSubject2,
        student[counter].marksSubject3
            );
            counter++;
        }


        fileToRead.close();
        cout << "> Records loaded successfully.\n\n";

    }catch(const string e)
    {
        cout << e;
    }
}

//Search Record by Name
void searchStudByName()
{
    if(counter == 0)
    {
        cout << "[!] Error. Nothing to search. Please add students to perform this action.\n";
        return;
    }

    bool validName = false;
    bool nameMatched = false;
    string name;
    do
    {
        try
        {
            cout << "Enter name to search: ";
            getline(cin >> ws, name); // Clear leading whitespace

            for (char ch : name)
            {
                if (!isalpha(ch) && ch != ' ')
                    throw string("[!] Invalid Input. Name can only contain letters and spaces.\n");
            }

            if (name.length() < 3 || name.length() > 50)
                throw string("[!] Invalid Input. Length of Name should be between 3 to 50 characters.\n");
            validName = true;
        }
        catch (const string& e)
        {
            cout << e;
        }
    } while (!validName);

    for(int i=0; i<counter; i++)
    {
        if(student[i].name == name)
        {
            cout << "\nRecord Found:" << endl;
            cout << "Roll No: " << student[i].rollNo << endl;
            cout << "Name: " << student[i].name << endl;
            cout << "Gender: " << student[i].gender << endl;
            cout << "Age: " << student[i].age << endl;
            cout << "CGPA: " << student[i].cgpa << endl;
            cout << "Total Marks: " << student[i].totalMarks << endl;
            cout << "Grade: " << student[i].grade << endl;
            cout << "City: " << student[i].city << endl;
            cout << "Mobile: " << student[i].mobile << endl;
            nameMatched = true;
        }
    }
    if(!nameMatched)
    {
        cout << "\n[!] Error. No Record Exist with this name.\n";
    }
}

//Function: Deleting Record From File
void delRecordByRollNo()
{
    if(counter == 0)
    {
        cout << "[!] Error, No Record found. Please Add Records first.\n";
        return;
    }

    int rollNo;
    bool foundRollNo = false;
    do
    {
        try
        {
            cout << "Enter Roll No to delete: ";
            cin >> rollNo;

            if(cin.fail())
            {
                cin.clear();
                cin.ignore(1000, '\n');
                throw string("[!] Invalid Input. Roll no must be integer.\n");
            }
            if(rollNo<1)
                throw string("[!] Invalid Input. Roll no must be positive.\n");

            for(int i=0; i<counter; i++)
            {
                if(student[i].rollNo == rollNo)
                {
                    for(int j=i; j<counter-1; j++)
                    {
                        student[j] = student[j+1];
                    }
                    foundRollNo = true;
                    counter--;
                    cout << "> Record deleted successfully.\n\n";
                    break;
                }
            }
            if(!foundRollNo)
            {
                cout << "[!] Student not found. Please check the roll number.\n\n";
            }
            break;
        }
        catch(const string e)
        {
            cout << e;
        }

    }while(true);
}

void updateRecordByMobileNo()
{
    if (counter == 0)
    {
        cout << "[!] No records found. Please add students before performing this action.\n";
        return;
    }

    string mobileNo;
    string newCity;
    bool foundMobileNo = false;

    do
    {
        try
        {
            cout << "Enter mobile number to update: ";
            cin >> mobileNo;

            for (char ch : mobileNo)
            {
                if (isalpha(ch))
                    throw string("[!] Error: Alphabets or special characters can't be used in mobile number.\n");
            }

            if (mobileNo.length() != 11)
                throw string("[!] Error: Mobile number length should be 11.\n");

            for (int i = 0; i < counter; i++)
            {
                if (student[i].mobile == mobileNo)
                {
                    foundMobileNo = true;

                    while (true)
                    {
                        try
                        {
                            cout << "Enter new city: ";
                            cin >> newCity;

                            for (int j = 0; j < newCity.length(); j++)
                            {
                                if (!isalpha(newCity[j]))
                                    throw string("[!] Error: Digits or special characters can't be used in city name.\n");
                                newCity[j] = tolower(newCity[j]);
                            }

                            newCity[0] = toupper(newCity[0]);
                            student[i].city = newCity;

                            cout << "> Record updated successfully.\n\n";
                            break; // break city input loop
                        }
                        catch (const string &e)
                        {
                            cout << e;
                        }
                    }

                    break; // break search loop after updating
                }
            }

            if (!foundMobileNo)
            {
                cout << "[!] No record found with this mobile number.\n\n";
            }

            break; // break mobile input loop
        }
        catch (const string &e)
        {
            cout << e;
        }

    } while (true);
}

//Function: Sorting Record in file
void sortRecordByRollNo()
{
    if(counter==0)
    {
        cout << "[!] Sorting failed. Add at least one student before sorting.\n";
        return;
    }

    sort(student, student + counter, [](const Students &a, const Students &b) {
        return a.rollNo < b.rollNo;
    });

    cout << "> Records sorted successfully by Roll Number.\n";
}

//Helpers

// Get Valid Roll No
int getValidRollNo(string prompt)
{
    int rollNo;
    do
    {
        try
        {
            cout << prompt;
            cin >> rollNo;

            if(cin.fail())
            {
                cin.clear();
                cin.ignore(1000, '\n');
                throw string("[!] Invalid roll number. Enter a positive number that is not already used.\n");
            }
            if(rollNo<0)
                throw string("[!] Invalid roll number. Enter a positive number that is not already used.\n");
            if(rollNo==0)
                throw string("[!] Invalid roll number. Enter a positive number greater than zero that is not already used.");
            if(duplicateRollNo(rollNo))
                throw string("[!] Duplicate entry. A student with this roll number already exists.\n");

            return rollNo;
        }
        catch(const string e)
        {
            cout << e;
        }

    }while(true);
}

//Get Valid Name
string getValidName(string prompt)
{
    bool validName = false;
    string name;
    do
    {
        try
        {
            cout << prompt;
            getline(cin >> ws, name); // Clear leading whitespace

            for (char ch : name)
            {
                if (!isalpha(ch) && ch != ' ')
                    throw string("[!] Invalid name. Use only letters and spaces (e.g., 'Hafiz Arham').\n");
            }

            if (name.length() < 3 || name.length() > 50)
                throw string("[!] Invalid Input. Length of name should be in-between 3 and 50 characters.\n");
            validName = true;
            return name;
        }
        catch (const string& e)
        {
            cout << e;
        }
    } while (!validName);
}

//Get Valid Gender
string getValidGender(string prompt)
{
    bool validGender = false;
    string gender;
    do
    {
        try
        {
            cout << prompt;
            cin >> gender;

            for(int i=0; i<gender.length(); i++)
            {
                if(!isalpha(gender[i]))
                    throw string("Digits or Special characters can't be use in gender. Please enter 'Male', 'Female', or 'Other'.\n");
                gender[i] = tolower(gender[i]);
            }
            gender[0] = toupper(gender[0]);
            if(gender!="Male" && gender!="Female" && gender!="Other")
                throw string("[!] Invalid gender. Please enter 'Male', 'Female', or 'Other'.\n");
            validGender = true;
            return gender;
        }catch(const string e)
        {
            cout << e;
        }
    }while(!validGender);
}

//Get Valid Age
int getValidAge(string prompt)
{
    bool validAge = false;
    int age;

    do
    {
        try
        {
            cout << prompt;
            cin >> age;

            if(cin.fail())
            {
                cin.clear();
                cin.ignore(1000, '\n');
                throw string("[!]Invalid age. Age must be integer. Please enter a number between 10 and 100.\n");
            }
            if(age<10 || age>100)
                throw string("[!] Invalid age. Please enter a number between 10 and 100.\n");
            validAge = true;
            return age;
        }catch(const string e)
        {
            cout << e;
        }

    }while(!validAge);
}

//Get Valid CGPA
float getValidCgpa(string prompt)
{
    float cgpa;
    bool validCgpa = false;

    do
    {
        try
        {
            cout << prompt;
            cin >> cgpa;

            if(cin.fail())
            {
                cin.clear();
                cin.ignore(1000, '\n');
                throw string("[!]Invalid Input. CGPA must be float. Enter a value between 0.00 and 4.00.\n");
            }
            if(cgpa>4.0 || cgpa<0.0)
            {
                throw string("[!] Invalid CGPA. Enter a value between 0.00 and 4.00.\n");
            }
            validCgpa = true;
            return cgpa;
        }catch(const string e)
        {
            cout << e;
        }
    }while(!validCgpa);
}

//Get Valid City
string getValidCity(string prompt)
{
    string city;
    bool validCity = false;
    do {
        try {
            cout << prompt;
            getline(cin >> ws, city);
            if (city.length() < 2 || city.length() > 50)
                throw string("[!] City name should be in-between 2 to 50 characters.\n");
            for (char ch : city)
            {
                if (!isalpha(ch) && ch != ' ')
                    throw string("[!] Invalid city name. Only letters and spaces are allowed.\n");
            }
            for(int i=0; i<city.length(); i++)
            {
                if(!isalpha(city[i]))
                    throw string("[!] Invalid city name. Only letters and spaces are allowed.\n");
                city[i] = tolower(city[i]);
            }
            city[0] = toupper(city[0]);
            validCity = true;
            return city;
        } catch (const string& e) {
            cout << e;
        }
    } while (!validCity);
}

//Get Valid Mobile
string getValidMobile(string prompt)
{
    bool validMobile = false;
    string mobile;
    do
    {
        try
        {
            cout << prompt;
            cin >> mobile;

            for(char ch: mobile)
            {
                if(isalpha(ch))
                    throw string("[!]Error. Alphabets or Special characters can't be used in Mobile number. It must be exactly 11 digits (e.g., 03014567890).\n");
            }
            if(mobile.length()!=11)
                throw string("[!] Invalid mobile number. It must be exactly 11 digits (e.g., 03014567890).\n");
                validMobile = true;
                return mobile;
        }catch(const string e)
        {
            cout << e;
        }
    }while(!validMobile);
}

//Get Valid Marks
float getValidMarks(string prompt)
{
    float marks;
    bool validMarks = false;

    do
    {
        try
        {
            cout << prompt;
            cin >> marks;

            if(cin.fail())
            {
                cin.clear();
                cin.ignore(1000, '\n');
                throw string("[!]Error. Marks should be Integer. Enter a value between 0 and 100.\n");
            }
            if(marks>100 || marks<0)
                throw string("[!] Invalid marks. Enter a value between 0 and 100.\n");
                validMarks = true;
                return marks;
        }catch(const string e)
        {
            cout << e;
        }
    }while(!validMarks);
}
//Total Marks of Each student
float getTotalMarks(float marks1, float marks2, float marks3)
{
    return marks1 + marks2 + marks3;
}
//Grade
char getGrade(float totalMarks)
{
    float percentage = (totalMarks * 100.0f) / 300.0f;
    if(percentage>=85) return 'A';
    else if(percentage>=75) return 'B';
    else if(percentage>=65) return 'C';
    else if(percentage>=50) return 'D';
    else return 'F';
}
//Duplicate Roll no
bool duplicateRollNo(int rollNo)
{
    for(int i=0; i<counter; i++)
    {
        if(rollNo == student[i].rollNo)
            return true;
    }
    return false;
}
