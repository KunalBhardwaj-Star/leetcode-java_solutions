# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        p1 , p2 = list1 , list2
        ans = ListNode(0)
        temp = ans

        while p1 and p2 :
            if p1.val < p2.val :
                temp.next = p1
                temp = temp.next
                p1 = p1.next

            else :
                temp.next = p2
                temp = temp.next
                p2 = p2.next

        while p1 :
            temp.next = p1
            temp = temp.next
            p1 = p1.next

        while p2 :
            temp.next = p2
            temp = temp.next
            p2 = p2.next

        return ans.next