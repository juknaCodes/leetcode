#include <iostream>
#include "ListNode.h"

void push(struct ListNode** head_ref, int new_data)
{
	/* allocate node */
	struct ListNode* new_node =
		(struct ListNode*) malloc(sizeof(struct ListNode));

	/* put in the data  */
	new_node->val = new_data;

	/* link the old list off the new node */
	new_node->next = (*head_ref);

	/* move the head to point to the new node */
	(*head_ref) = new_node;
}


void printList(struct ListNode* node)
{
	while (node != NULL)
	{
		printf("%d ", node->val);
		node = node->next;
	}
}