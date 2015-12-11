#Dynamic Visual Code Specification

##Groups
- A group contains a group of adjacent pixels with the same color as most intense.
- References to children (determined by their parent) and a parent (determined by adjacent group of lowest tier, if more than one, dvcode is invalid).
- Tier determined by number of indirect parents.
- Type {R, G, B} determined by most intense color component.

###Initial Group
- Surrounds all other groups in a dvcode.
- Type determines code type:
 - R - Modulo 2 (1 bit per group) evaluations, types provide preceding bit.
 - G - Modulo 4 (2 bits per group), types provide preceding bit.
 - B - Modulo 8 (3 bits per group), types provide no extra data.
- Group must fully envelope the image being processed.

###Group Valuation
- Value of 
- Initial bit based off type and parent's type, initial group's type permitting.
 - Parent -> Group = X
 - R -> G = 0
 - R -> B = 1
 - G -> R = 0
 - G -> B = 1
 - B -> R = 0
 - B -> G = 1
- Value
