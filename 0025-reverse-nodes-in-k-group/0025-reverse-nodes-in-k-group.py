# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    def getKth(self , head: Optional[ListNode] , k: int) -> Optional[ListNode]:
        curr = head

        while curr and k > 0:
            curr = curr.next
            k -= 1

        return curr

    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head

        groupPrev = dummy

        while True :
            kth = self.getKth(groupPrev , k)

            if kth == None:
                break

            groupNext = kth.next
            prev = groupNext
            curr = groupPrev.next

            while curr is not groupNext :
                nxt = curr.next
                curr.next = prev
                prev = curr
                curr = nxt

            temp = groupPrev.next
            groupPrev.next = kth
            groupPrev = temp

        return dummy.next


        