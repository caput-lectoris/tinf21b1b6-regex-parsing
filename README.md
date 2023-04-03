# Regular Expression Parsing (KA-TINF21B1 + B6)

> 📝 **Please Note:** This repository is part of a lecture series on compiler construction at the [Baden-Württemberg Cooperative State University Karlsruhe](https://www.karlsruhe.dhbw.de/en/general/about-dhbw-karlsruhe.html) in Germany. Special to this university are the career-integrated undergraduate study programs. In alternating three-month phases, students learn theory at the university and receive practical training from an enterprise. The students have an employment contract, and throughout the entire period, they receive a monthly salary and have the insurance status of employees. For a listing of lecture content, see section T3INF4211 in the [university's module handbook](https://www.dhbw.de/fileadmin/user/public/SP/KA/Informatik/Informatik.pdf).


A simple implementation of Thompson's construction algorithm to transform an arbitrary regular expression into an equivalent nondeterministic finite automaton (ε-NFA). Think of it as a library that others can incorporate into their projects, except that it is for educational purposes and not for production use.

The unit tests in class [ParserTest](https://github.com/caput-lectoris/tinf21b1b6-regex-parsing/blob/main/src/test/java/de/dhbw/caput/tinf21b1b6/ParserTest.java) demonstrate how the automata can be generated. Note that almost half of the unit tests break because the regular expressions are strings as usual, while the algorithm requires an object tree. To solve exactly this problem, a [Parser](https://github.com/caput-lectoris/tinf21b1b6-regex-parsing/blob/main/src/main/java/de/dhbw/caput/tinf21b1b6/Parser.java) has been provided. However, the method was implemented only as a dummy, accompanied by a TODO comment. It is up to the students to develop a better strategy.

Please also note that for simplicity, we use the infix operator `·` in a concatenation. Usually, concatenation comes without an operator.


## Setup

The project already comes with a Maven configuration in a file named `pom.xml`. Apache Maven is a powerful tool to automate many processes involved in software development. Here, only dependency management is used.

`mvn test` or a similar function in your IDE should be sufficient to build the entire project and run the tests.


## Contributing

The project is kept small on purpose. It does not intend to offer as many features as possible or to be particularly powerful. Please consider this before creating a pull request. Functional enhancements are likely to be rejected. Changes, however, that serve usability, clarity, structure or better understanding are always welcome.
