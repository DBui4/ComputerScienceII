from operator import attrgetter

# A group may consist of one or more students
# and has a direct connection to both canvas 
# in which students are either assigned or self
# select into groups.  In the case that students
# are not assigned to a group, a python Group
# object is still created for them as a "group 
# of one".
#
# Codepost does not represent groups directly, however
# each submission may have more than one student 
# assicated with it.
#
class Group:
    canvasGroupId   = None
    canvasGroupName = None
    # This is an array of Persons
    members = []
    
    def __init__(self, canvasGroupId = None,
                       canvasGroupName = None):
        self.canvasGroupId   = canvasGroupId
        self.canvasGroupName = canvasGroupName
    def __str__(self):
        if len(self.members) > 1:
          s = "  %-20s (%s) \n"%(self.canvasGroupName,self.canvasGroupId)
        else:
          s = "  %-20s \n"%("Group of One")
        for member in self.members:
          s += "    %s\n"%(member)
        return s
    def __eq__(self,other):
        return self.members == other.members        
    def __lt__(self,other):
        return (self.members[0].name < other.members[0].name)
    def addMembers(self, members):
        self.members = sorted(members, key=attrgetter('name'))
