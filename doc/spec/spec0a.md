#Dynamic Visual Code Specification

##Groups
- A group contains a group of adjacent pixels with the same component (red, green, blue) as most intense.
- References to children (determined by their parent) and a parent (determined by adjacent group of lowest tier, if more than one, dvcode is invalid).
- Tier determined by number of indirect parents.
- Type {R, G, B} determined by most intense color component. If components are of equal intensity it is undefined but the dvcode is not invalid.

###Initial Group
- Surrounds all other groups in a dvcode.
- Type determines code type:
 - R - Modulo 2 (1 bit per group) evaluations, types provide preceding bit.
 - G - Modulo 4 (2 bits per group), types provide preceding bit.
 - B - Modulo 8 (3 bits per group), types provide no extra data.
- Group must fully envelope the image being processed.

###Group Valuation
- The value of a group is an array of bits, based on its and its children's structure and colors
- Initial bit based off type and parent's type, initial group's type permitting.
 - Parent -> Group = X
 - R -> G = 0
 - R -> B = 1
 - G -> R = 0
 - G -> B = 1
 - B -> R = 0
 - B -> G = 1
- Value is based off (the number of children groups - 1) modulo of initial group type, nothing if 0 children.
- Valuation of Red, Green, Blue type children are appended in order. In the case of multiple of the same type of children:
 - Children with 0 children are ignored unless there are none of the same type with more than 1 child.
 - Valuation of type of child is given by the valuation that the most children of that type return.
 - In the case of a tie, the longest valuation is used.
