#Dynamic Visual Code Specification

##Groups
- A group contains a group of adjacent pixels with the same color as most intense.
- References to children (determined by their parent) and a parent (determined by adjacent group of lowest tier, if more than one, code is invalid).
- Tier determined by number of indirect parents.
- Type {R, G, B} determined by most intense color component

###Initial Group
- Surrounds all other groups in dvcode.
- Type determines code type:
 - R - Modulo 2 evaluations, types provide no extra data
 - G - Modulo 4, types provide preceding bit
 - B - Modulo 8, types provide preceding bit
