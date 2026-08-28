# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    def merge(self , list1: Optional[ListNode] , list2: Optional[ListNode]):
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

        temp.next = p1 if p1 else p2

        return ans.next

    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        n = len(lists)

        if n == 0 or (n == 1 and lists[0] == None):
            return None

        ans = lists[0]

        for x in range(1 , n):
            ans = self.merge(ans , lists[x])

        return ans