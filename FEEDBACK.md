"In the README file put some information about the work - after all, this is on a public repo.
Good set of tests.
Considering each of the eight points in turn:
1)  Good. 
public Object getReturnValue() { if (hasError()) { return null; } else { return value; } }
could be return (hasError() ? null : value)
which is a little more compact and descriptive.
2) Good.
3) Take a look at the example on Moodle to see how you could have used inner classes to avoid exposing the node.
4) Very good (so were the other ""goods"" but I'm struggling to say anything about this ""correct"" code.
5) Good.
6) SampleableList implementation should have followed convention on naming (or did I miss where you said what the implementation was called?)
7) Good.
8) Good.
Excellent effort."
