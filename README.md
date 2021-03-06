# LaTeX-Generator

Hello!

This is a LaTeX code generator and converter which can generator LaTeX code for formatted Truth Tables, and for listed steps of logical propositoinal/boolean algebra simplifications. It does text replacement for ASCII an ascii version of logical symbols and changes them into LaTeX equivalent. 

The goal of this program is that you can type the parameters of the LaTeX structure you want into a .txt file and the code generates the structure in LaTeX code, so the user doesn't have to deal with the specific syntax of LaTeX tables and expressions. 

## Propositional Logic / Boolean Algebra simplifications

For logical expressions the following ASCII characters can be written in the proofLines.txt file to be interpreted by the converter:

|Symbol | Logical Name | LaTeX replace  |
|----|----|----|
|\>     | Implication  | \rightarrow    |
|<>     | Biimplication| \leftrightarrow|
|&      | Logical And          | \land          |
|x      | And (Algebra)| \cdot          |
|v      | Logical Or           | \lor           |
|+      | Or (Algebra)          | +              |
|~      | Negation     | \neg           |
|'      | Negation (Algebra)| '         |

Each line of a simplification (except the first line stating the propostion) is paired with a reason for the simplification, which is seperated by a semicolon (;), so for example the following code written into proofLines.txt:

```
(p v q) > r
~(p v q) v r ; law of implication
(~p & ~q) v r ; de morgan's law
```

Would output the following code in LaTeX after the program runs:
```
\begin{center}
\begin{tabular}{c c c}
$(p \lor q) \rightarrow r$ &&\\
$\equiv$ & $\neg (p \lor q) \lor r $ & law of implication\\
$\equiv$ & $(\neg p \land \neg q) \lor r $ & de morgan's law\\
\end{tabular}
\end{center}
```
Additional Notes:
  - A basic "well-formed" checker is implememented, that scans each line of your proof to make sure there are a equal number of open and close parentheses. If there is an error (e.g. unequal parentheses) then the problem and line number are outputed to the console.
  - Skipping lines is fine, the converter will just ignore them. However white space between characters may affect the outputted LaTeX code, however because of how LaTeX renders white space, there is not much of a chance this will cause a problem
  - The first line of the document does not have a reason next to it. This is just the origianl expression and should alawya sbe the first line in the simplification


