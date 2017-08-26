#include <iostream>
#include "List.h"

using namespace std;

ListNode *detectCycle(ListNode *head);

void main() {
	ListNode * head = NULL;
	push(&head,50);
	push(&head, 20);
	push(&head, 15);
	push(&head, 4);
	push(&head, 10);
 
    /* Create a loop for testing */
    head->next->next->next->next->next = head;
	detectCycle(head);
}

ListNode *detectCycle(ListNode *head) {
	// If list is empty or has only one node
	// without loop
	if (head == NULL || head->next == NULL)
		return NULL;

	ListNode *slow = head, *fast = head;

	// Move slow and fast 1 and 2 steps
	// ahead respectively.
	slow = slow->next;
	fast = fast->next->next;

	// Search for loop using slow and
	// fast pointers
	while (fast && fast->next)
	{
		if (slow == fast)
			break;
		slow = slow->next;
		fast = fast->next->next;
	}

	/* If loop exists */
	if (slow == fast)
	{
		slow = head;
		while (slow!= fast)
		{
			slow = slow->next;
			fast = fast->next;
		}

		/* since fast->next is the looping point */
		return slow;
	}
	return NULL;
}