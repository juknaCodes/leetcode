#include <iostream>
#include "List.h"

using namespace std;
void deleteNode(ListNode* node);

void main() {
	ListNode* head = NULL;

	//push(&head, 7);
	//1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6
	push(&head, 6);
	push(&head, 5);
	push(&head, 4);
	push(&head, 3);
	push(&head, 6);
	push(&head, 2);
	push(&head, 1);
	deleteNode(head);
}

void deleteNode(ListNode* node) {
	ListNode*node_next = node->next;
	node->next = node->next->next;
	node->val = node_next->val;

}